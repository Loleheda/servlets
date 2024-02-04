package org.example.data;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private List<Message> messageList = new ArrayList<>();

    public List<Message> getMessageList() {
        return messageList;
    }

    public void addMessage(User user, String message) {
        messageList.add(new Message(user, message));
    }
}
