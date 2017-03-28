import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServerTCP {

    int portNumber = 2345;
    Map<PrintWriter,String> clientOutputStreams;

    public ServerTCP() {
        System.out.println("Server ready. Listening..." );
        clientOutputStreams = new ConcurrentHashMap<>();

        Thread listenerUDP = new Thread(new ListenerUDP());
        listenerUDP.start();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
                System.out.println("Incoming connection registered.");
            }
        } catch (IOException e) {
            try {
                serverSocket.close();
            } catch (IOException e1) {
                System.out.println("Exception while closing socket.");
            }
            e.printStackTrace();
        }
    }

    class ListenerUDP implements Runnable {

        DatagramSocket socketUDP = null;

        @Override
        public void run() {
            try {
                socketUDP = new DatagramSocket(portNumber);
                byte[] receiveBuffer = new byte[128];

                while (true){

                    DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                    socketUDP.receive(receivePacket);

                    String msg = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
                    System.out.println("received msg: " + msg);

                }
            } catch (IOException e) {
                socketUDP.close();
                e.printStackTrace();
            }
        }
    }

   class ClientHandler implements Runnable {

        BufferedReader reader;
        Socket socket;

        public ClientHandler(Socket clientSocket) {
            try {
                socket = clientSocket;
                InputStreamReader isr =
                        new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            String nameClient = null;
            try {
                while ((message = reader.readLine()) != null) {
                    if (nameClient == null){
                        nameClient = message;
                        PrintWriter writer =
                                new PrintWriter(socket.getOutputStream());

                        clientOutputStreams.put(writer,nameClient);
                        System.out.println(nameClient + " registered.");
                    }
                    else {
                        System.out.println("Read: " + message);
                        tellEveryone(message, nameClient);
                    }
                }
            } catch (IOException e) {
                System.out.println(nameClient + " disconnected.");
            }
        }
    }

    public void tellEveryone(String message, String from) {
        clientOutputStreams.keySet().stream()
                .filter(writer -> !from.equals(clientOutputStreams.get(writer)))
                .forEach(writer -> {
            writer.println(message);
            writer.flush();
        });
    }

    public static void main(String[] args) {
        new ServerTCP();
    }
}