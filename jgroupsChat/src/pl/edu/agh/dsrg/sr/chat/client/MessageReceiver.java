package pl.edu.agh.dsrg.sr.chat.client;

import com.google.protobuf.InvalidProtocolBufferException;
import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import pl.edu.agh.dsrg.sr.chat.protos.ChatOperationProtos;

/**
 * Created by Suota on 2017-03-25.
 */
public class MessageReceiver extends ReceiverAdapter {

    private final JChannel channel;

    public MessageReceiver(JChannel channel) {
        this.channel = channel;
    }

    @Override
    public void receive(Message msg) {
        try {
            String text = ChatOperationProtos.ChatMessage.parseFrom(msg.getBuffer()).getMessage();
            String channelName = channel.getClusterName();
            String nick = channel.getName(msg.getSrc());

            System.out.println(channelName +", "+ nick +" : "+text);
        } catch (InvalidProtocolBufferException e) {
            System.out.println("Invalid Protocol Buffer while receiving");
        }
    }

}
