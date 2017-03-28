package pl.edu.agh.dsrg.sr.chat.client;

/**
 * Created by Suota on 2017-03-23.
 */

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.protocols.*;
import org.jgroups.protocols.pbcast.*;
import org.jgroups.stack.Protocol;
import org.jgroups.stack.ProtocolStack;
import pl.edu.agh.dsrg.sr.chat.protos.ChatOperationProtos;
import pl.edu.agh.dsrg.sr.chat.protos.ChatOperationProtos.ChatAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleChat implements ISimpleChat {

    private JChannel managementChannel;
    private Map<String, List<String>> usersMap = new ConcurrentHashMap<>();
    private Map<String, JChannel> channelsMap = new HashMap<>();
    private String nick;

    public SimpleChat(){
        nick = requestNick();
        try {
            joinManagementChnanel();
        } catch (Exception e) {
            System.out.println("Joining the management channel failed");
        }
    }

    private void printMenu(){

        System.out.println("-----------------Chat options: -------------------------------");
        System.out.println("L                          - list all channels and users");
        System.out.println("J <channel name>           - join channel <channel name>");
        System.out.println("U <channel name>           - leave channel <channel name>");
        System.out.println("<channel name>:<message>   - send <message> to <channel name>");
        System.out.println("H                          - print this help ");
        System.out.println("--------------------------------------------------------------- ");

    }

    private void setStack(ProtocolStack stack, InetAddress address){
        Protocol udp = new UDP();
        if (address != null) {
            udp.setValue("mcast_group_addr", address);
        }

        stack.addProtocol(udp)
                .addProtocol(new PING())
                .addProtocol(new MERGE3())
                .addProtocol(new FD_SOCK())
                .addProtocol(new FD_ALL().setValue("timeout", 12000).setValue("interval", 3000))
                .addProtocol(new VERIFY_SUSPECT())
                .addProtocol(new BARRIER())
                .addProtocol(new NAKACK2())
                .addProtocol(new UNICAST3())
                .addProtocol(new STABLE())
                .addProtocol(new GMS())
                .addProtocol(new UFC())
                .addProtocol(new MFC())
                .addProtocol(new FRAG2())
                .addProtocol(new STATE_TRANSFER())
                .addProtocol(new FLUSH());
        try {
            stack.init();
        } catch (Exception e) {
            System.out.println("Protocol stack initialization failed");
        }
    }

    public void start(){
        printMenu();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputText;
        try {
            while ((inputText = input.readLine()) != null) {

                if (inputText.equals("L")) {
                    printChannelsInfo();
                } else if(inputText.startsWith("J")) {
                    try {
                        joinChannel(inputText.substring(1).trim());
                    } catch (Exception e) {
                        System.out.println("Joining channel failure");
                    }
                } else if(inputText.startsWith("H")) {
                    printMenu();
                } else if(inputText.startsWith("U")) {
                    leaveChannel(inputText.substring(1).trim());
                } else {
                    String [] parts = inputText.split(":");
                    if(parts.length == 2){
                        sendMessage(parts[0].trim(),parts[1]);
                    }
                    else {
                        System.out.println("Invalid input, please stick to the rules:");
                        printMenu();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Readline input failure");
        }
    }

    private void printChannelsInfo(){
        usersMap.keySet().forEach(channel -> {
            System.out.print("\n"+channel + " : ");
            usersMap.get(channel).forEach(user -> System.out.print(user + ", "));
            System.out.println();
        });
    }
    private String requestNick(){

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter Your nick: ");
        String name = null;

        try {
            name = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(name == null ){
            System.exit(1);
        }
        return name;
    }

    @Override
    public void joinManagementChnanel() throws Exception {

        managementChannel = new JChannel(false);
        managementChannel.setName(nick);
        ProtocolStack protocolStack = new ProtocolStack();
        managementChannel.setProtocolStack(protocolStack);
        setStack(protocolStack,null);

        managementChannel.setReceiver(new ManagementReceiver(usersMap, managementChannel));
        managementChannel.connect("ChatManagement321321");
        managementChannel.getState(null, 10000);
    }

    @Override
    public void leaveManagementChannel() {
        managementChannel.close();
    }

    @Override
    public void joinChannel(String name) throws Exception {
        if (channelsMap.containsKey(name)) {
            channelsMap.get(name);
            System.out.println("Switched to existing channel: " + name);
            return;
        }
        InetAddress address = InetAddress.getByName(name);
        JChannel channel = new JChannel(false);
        channel.setName(nick);

        ProtocolStack protocolStack = new ProtocolStack();
        channel.setProtocolStack(protocolStack);

        setStack(protocolStack, address);

        channel.setReceiver(new MessageReceiver(channel));
        channel.connect(name);

        channelsMap.put(name, channel);

        ChatAction chatAction = ChatAction.newBuilder()
                .setAction(ChatAction.ActionType.JOIN)
                .setNickname(nick).setChannel(name).build();

        Message msg = new Message(null, null, chatAction.toByteArray());

        if (!usersMap.containsKey(name)) {
            usersMap.put(name, new LinkedList<>());
        }
        managementChannel.send(msg);
    }

    @Override
    public void leaveChannel(String name) {
        if (!channelsMap.containsKey(name)) {
            System.out.println("You did not join this channel");
            return;
        }

        JChannel channel = channelsMap.get(name);
        channelsMap.remove(name);

        ChatAction action = ChatAction.newBuilder()
                .setAction(ChatAction.ActionType.LEAVE)
                .setNickname(nick).setChannel(name).build();

        try {
            managementChannel.send(new Message(null, null, action.toByteArray()));
        } catch (Exception e) {
            System.out.println("Sending leave message failed");
        }

        channel.close();
    }

    @Override
    public void sendMessage(String channelName, String message) {
        if (!channelsMap.containsKey(channelName)) {
            System.out.println("You did not join this channel");
            return;
        }

        JChannel channel = channelsMap.get(channelName);
        ChatOperationProtos.ChatMessage msg = ChatOperationProtos.ChatMessage.newBuilder()
                .setMessage(message).build();
        try {
            channel.send(new Message(null, null, msg.toByteArray()));
        } catch (Exception e) {
            System.out.println("Sending message failed");
        }
    }
}
