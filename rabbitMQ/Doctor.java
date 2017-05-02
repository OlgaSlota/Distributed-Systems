import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Suota on 2017-04-15.
 */
public class Doctor {
    static final String exchangeName = "EXCHANGE";
    private Channel channel;
    private String doctorQueue;
    private String doctorName;

    private void initCommunication() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
        } catch (Exception e) {
            System.out.println("Exception while creating the channel");
        }
        try {
            channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC);
            channel.exchangeDeclare(Administrator.adminExchangeName, BuiltinExchangeType.FANOUT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            doctorQueue = channel.queueDeclare(doctorName, false, false, false, null).getQueue();
            channel.queueBind(doctorQueue, exchangeName, "hospital.doctors." + doctorName);
            channel.queueBind(doctorQueue, Administrator.adminExchangeName, "");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class DoctorsPublisher extends Thread {
        BufferedReader br;

        DoctorsPublisher(BufferedReader br) {
            this.br = br;
        }

        @Override
        public void run() {
            while (true) {
                String examinationType = null;
                String patientName = null;
                try {
                    System.out.println("Type of examination: ");
                    examinationType = br.readLine();
                    System.out.println("Patient's name: ");
                    patientName = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String message = doctorName + " - " + examinationType + " - " + patientName;

                try {
                    channel.basicPublish(exchangeName, "hospital.examination." + examinationType, null, message.getBytes("UTF-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Sent examination request: " + message);
            }
        }
    }

    private class DoctorsListener extends Thread {
        String queueName;
        Channel channel;

        private DoctorsListener(String queueName, Channel channel) {
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
                }
            };
            try {
                channel.basicConsume(queueName, false, consumer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Doctor name: ");
        try {
            doctor.doctorName = br.readLine();
        } catch (IOException e) {
            System.out.println("Exception while reading input");
        }
        doctor.initCommunication();
        Thread publisher = doctor.new DoctorsPublisher(br);
        Thread listener = doctor.new DoctorsListener(doctor.doctorQueue, doctor.channel);
        publisher.start();
        listener.start();    }


}
