import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import static java.net.InetAddress.*;

public class ClientTCP {

    int portNumber = 2345;
    int mcPortNumber = 12345;
    BufferedReader input;
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;
    DatagramSocket socketUDP;
    MulticastSocket mcSocket = null;
    String nameClient;
    private final static String HOST_NAME = "localhost";
    InetAddress mcIPAddress;


    ClientTCP() {

        try {
            mcIPAddress = getByName("230.1.1.1");
            mcSocket = new MulticastSocket(mcPortNumber);
            System.out.println("Multicast Receiver running...");
            mcSocket.joinGroup(mcIPAddress);

        } catch (IOException e) {
            e.printStackTrace();
        }

        input = new BufferedReader(new InputStreamReader(System.in));

        setUpNetworking();
        System.out.println("Please Enter Your nick: ");
        try {
            nameClient = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println(nameClient);
        writer.flush();

        Thread sender = new Thread(new MessageSender());
        sender.start();

        Thread receiver = new Thread(new MessageHandler());
        receiver.start();

        Thread receiverUDP = new Thread(new MessageHandlerUDP());
        receiverUDP.start();



    }

    void setUpNetworking() {

        try {
            socket = new Socket(HOST_NAME, portNumber);
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);
            writer = new PrintWriter(socket.getOutputStream());

            socketUDP = new DatagramSocket();

            System.out.println("Networking established");

        } catch (IOException e) {
            socketUDP.close();
            System.out.println("Caught exception. Socket closed.");
    }
    }

    class MessageHandler implements Runnable {
        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null ) {
                    System.out.println("Read: " + message);
                }
            } catch (IOException e) {
                System.out.println("Lost connection with server.");
            }
        }
    }

    class MessageHandlerUDP implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    DatagramPacket received = new DatagramPacket(new byte[128], 128);
                    mcSocket.receive(received);
                    System.out.println("Read: " + new String(received.getData(), received.getOffset(), received.getLength()));
                }
            } catch (IOException e) {
                mcSocket.close();
                System.out.println("Caught exception. Socket closed.");            }
        }
    }
    class MessageSender implements Runnable{
        @Override
        public void run() {
            String message;
            try {
                while ((message = input.readLine()) != null) {

                    if (message.equals("M")) {
                        InetAddress address = getByName("localhost");
                        byte[] sendBuffer = (nameClient + ": UDP multimedia").getBytes();

                        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, portNumber);
                        socketUDP.send(sendPacket);

                    } else if (message.equals("N")) {
                        byte[] sendBuffer = (nameClient + ": UDP multimedia multicast").getBytes();

                        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, mcIPAddress, mcPortNumber);
                        mcSocket.send(sendPacket);

                    } else {

                        writer.println(nameClient + ": " + message);
                        writer.flush();
                    }
                }
            } catch (IOException e) {
                socketUDP.close();
                System.out.println("Caught exception. Socket closed.");
        }
        }
    }

    public static void main(String[] args) {
        new ClientTCP();
    }
}