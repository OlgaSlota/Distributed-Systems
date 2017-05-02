import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeoutException;

/**
 * Created by Suota on 2017-04-15.
 */
public class Technician {
    private String name;
    private BufferedReader br;
    private Set<String> possibleSkills = new HashSet<>(Arrays.asList("ankle", "elbow", "knee"));
    private String skill1 ;
    private String skill2 ;
    private Channel channel1;
    private Channel channel2;
    private String queue1;
    private String queue2;
    private String technicianQueue;

    private void initCommunication() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection;
        try {
            connection = factory.newConnection();
            channel1 = connection.createChannel();
            channel2 = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            channel1.exchangeDeclare(Doctor.exchangeName, BuiltinExchangeType.TOPIC);
            channel2.exchangeDeclare(Doctor.exchangeName, BuiltinExchangeType.TOPIC);
            channel1.exchangeDeclare(Administrator.adminExchangeName, BuiltinExchangeType.FANOUT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            queue1 = channel1.queueDeclare(skill1, false, false, false, null).getQueue();
            queue2 = channel2.queueDeclare(skill2, false, false, false, null).getQueue();

            technicianQueue = channel1.queueDeclare(name, false, false, false, null).getQueue();

            channel1.queueBind(queue1, Doctor.exchangeName, "hospital.examination." + skill1);
            channel2.queueBind(queue2, Doctor.exchangeName, "hospital.examination." + skill2);

            channel1.queueBind(technicianQueue, Administrator.adminExchangeName, "");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Communication successfully initialized.");
    }


    private void readSkills() throws IOException {
        System.out.println("Please insert comma separated skills of " + name );
        String [] skills = br.readLine().split(",");
        if (areValidSkills(skills)) {
            skill1 = skills[0].trim();
            skill2 = skills[1].trim();
        } else {
            System.out.println("Invalid skills.");
            readSkills();
            return;
        }
    }

    private boolean areValidSkills(String[] array) {
        if (array.length != 2) {
            return false;
        }
        if (possibleSkills.contains(array[0].trim()) && possibleSkills.contains(array[1].trim())) {
            return true;
        }
        return false;
    }

    private class TechnicianListener extends Thread {
        String queueName;
        Channel channel;

        private TechnicianListener(String queueName, Channel channel) {
            this.channel = channel;
            this.queueName = queueName;
        }

        public void run() {
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Received: " + message);
                    channel.basicAck(envelope.getDeliveryTag(), false);

                    if (!message.startsWith(Administrator.adminTag)) {
                        String[] splitRequest = message.split(" - ");
                        String doctorName = splitRequest[0];
                        String response = splitRequest[2] + " - " + "EXAMINATION RESULTS";

                        String key = "hospital.doctors." + doctorName;
                        channel.basicPublish(Doctor.exchangeName, key, null, response.getBytes("UTF-8"));
                    }
                }
            };
            try {
                channel.basicConsume(queueName, false, consumer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] argv) throws Exception {
        Technician technician = new Technician();
        technician.br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Technician name: ");
            technician.name = technician.br.readLine();
            technician.readSkills();
        } catch (IOException e) {
            e.printStackTrace();
        }
        technician.initCommunication();
        Thread listener1 = technician.new TechnicianListener(technician.queue1, technician.channel1);
        Thread listener2 = technician.new TechnicianListener(technician.queue2, technician.channel2);
        Thread listener3 = technician.new TechnicianListener(technician.technicianQueue, technician.channel1);
        listener1.start();
        listener2.start();
        listener3.start();
    }
}

