package pl.edu.agh.dsrg.sr.chat.client;

import com.google.protobuf.InvalidProtocolBufferException;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import pl.edu.agh.dsrg.sr.chat.protos.ChatOperationProtos;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Suota on 2017-03-25.
 */

public class ManagementReceiver extends ReceiverAdapter {

    private JChannel managementChannel;
    private Map<String, List<String>> usersMap;

    public ManagementReceiver(Map<String, List<String>> usersMap, JChannel managementChannel) {
        this.managementChannel = managementChannel;
        this.usersMap = usersMap;
    }

    @Override
    public void receive(Message msg) {
        ChatOperationProtos.ChatAction action = null;

        try {
            action = ChatOperationProtos.ChatAction.parseFrom(msg.getBuffer());
            String channelName = action.getChannel();
            String nickName = action.getNickname();

            switch (action.getAction()) {
                case JOIN:
                    if (!usersMap.containsKey(channelName)) {
                        usersMap.put(channelName, new LinkedList<>());
                    }
                    usersMap.get(channelName).add(nickName);
                    break;

                case LEAVE:
                    usersMap.get(channelName).remove(nickName);
                    if (usersMap.get(channelName).isEmpty()) {
                        usersMap.remove(channelName);
                    }
                    break;
            }
        } catch (InvalidProtocolBufferException e) {
            System.out.println("Receiving management message failed");
        }
        System.out.println(msg.getSrc() + " performed " + action.getAction() + " "+ action.getChannel());
    }

    @Override
    public void getState(OutputStream output) throws Exception {
        ChatOperationProtos.ChatState.Builder builder = ChatOperationProtos.ChatState.newBuilder();

        for (Map.Entry<String, List<String>> entry : usersMap.entrySet()) {
            String channelName = entry.getKey();
            List<String> users = entry.getValue();

            for (String user : users) {
                builder.addStateBuilder()
                        .setAction(ChatOperationProtos.ChatAction.ActionType.JOIN)
                        .setChannel(channelName).setNickname(user);
            }
        }
        ChatOperationProtos.ChatState state = builder.build();
        state.writeTo(output);
    }

    @Override
    public void setState(InputStream input) throws Exception {
        ChatOperationProtos.ChatState state = ChatOperationProtos.ChatState.parseFrom(input);
        usersMap.clear();

        for (ChatOperationProtos.ChatAction chatAction : state.getStateList()) {
            String channelName = chatAction.getChannel();

            if (!usersMap.containsKey(channelName)) {
                usersMap.put(channelName, new LinkedList<>());
            }
            usersMap.get(channelName).add( chatAction.getNickname());
        }
    }

    @Override
    public void viewAccepted(View view) {
        List<String> currentUsers = view.getMembers().stream()
                .map(address -> managementChannel.getName(address)).collect(Collectors.toList());

        for (Map.Entry<String, List<String>> entry : usersMap.entrySet()) {
            entry.getValue().retainAll(currentUsers);
        }
    }
}
