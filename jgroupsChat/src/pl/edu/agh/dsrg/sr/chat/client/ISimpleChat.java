package pl.edu.agh.dsrg.sr.chat.client;

/**
 * Created by Suota on 2017-03-25.
 */
public interface ISimpleChat {


    void joinManagementChnanel() throws Exception;

    void leaveManagementChannel();

    void joinChannel(String name) throws Exception;

    void leaveChannel(String name) throws Exception;

    void sendMessage(String channelName, String message) throws Exception;
}
