package org.example.data;

public class Message {
    private final User user;
    private final String massage;

    public Message(User user, String massage) {
        this.user = user;
        this.massage = massage;
    }

    public User getUser() {
        return user;
    }

    public String getMassage() {
        return massage;
    }
}
