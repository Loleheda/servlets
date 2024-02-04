package org.example.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataBase {

    private static final Map<String, User> users = new HashMap<>();
    private static Chat chat = new Chat();

    private DataBase() {
    }

    public static void init() {
        DataBase.users.put("admin", new User("admin", "admin", "admin", UserType.ADMIN));
        DataBase.users.put("Roman", new User("Roman", "Roman", "Roman", UserType.CLIENT));
        DataBase.users.put("Kirill", new User("Kirill", "Kirill", "Kirill", UserType.CLIENT));
        DataBase.users.put("Daria", new User("Daria", "Daria", "Daria", UserType.CLIENT));
        DataBase.chat.addMessage(DataBase.findUserByLogin("Roman"), "Привет");
        DataBase.chat.addMessage(DataBase.findUserByLogin("Kirill"), "Привет");
        System.out.println("Установка соединения с Базой Данных");
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }

    public static Map<String, User> getUsers() {
        return DataBase.users;
    }

    public static User findUserByLogin(String login) {
        return DataBase.users.get(login);
    }

    public static Chat getChat() {
        return DataBase.chat;
    }
}
