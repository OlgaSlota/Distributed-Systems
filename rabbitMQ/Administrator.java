import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeoutException;

/**
 * Created by Suota on 2017-04-20.
 */
public class Administrator {

    static final String adminExchangeName = "ADMIN_EXCHANGE";
    static final String adminTag = " <ADMINISTRATOR>  ";
    private BufferedReader br;
    private Channel channel;
    private String myQueue;
    private String myName;

    private void sendToAll() {
        while (true){
            String message = null;
            try {
                System.out.println("Admin message to send:");
                message = adminTag + br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                channel.basicPublish(adminExchangeName, "", null, message.getBytes("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initCommunication() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            channel.exchangeDeclare(Doctor.exchangeName, BuiltinExchangeType.TOPIC);
            channel.exchangeDeclare(adminExchangeName, BuiltinExchangeType.FANOUT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myQueue = channel.queueDeclare(myName, false, false, false, null).getQueue();
            channel.queueBind(myQueue, Doctor.exchangeName, "hospital.#");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class AdminListener extends Thread {
        private String queueName;
        private Channel channel;

        private AdminListener(String queueName, Channel channel) {
            this.channel = channel;
            this.queueName = queueName;
        }

        @Override
        public void run() {
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Logging message: " + message);
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
        Administrator admin = new Administrator();
        admin.br = new BufferedReader(new InputStreamReader(System.in));
        admin.myName = "Administrator";
        admin.initCommunication();
        Thread listener = admin.new AdminListener(admin.myQueue, admin.channel);
        listener.start();
        admin.sendToAll();
    }
}
