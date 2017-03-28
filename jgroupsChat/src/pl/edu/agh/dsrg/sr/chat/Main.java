package pl.edu.agh.dsrg.sr.chat;

import pl.edu.agh.dsrg.sr.chat.client.SimpleChat;

/**
 * Created by Suota on 2017-03-25.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.preferIPv4Stack","true");
        SimpleChat chat = new SimpleChat();
        chat.start();

    }
}
