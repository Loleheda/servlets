package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.data.UserType;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, User> users = DataBase.getUsers();
        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");
        User user = users.get(login);

        if (user != null && user.getPassword().equals(password)) {
            user.setOnline(true);
            request.getSession(true).setAttribute("user", user);
            if (user.getUserType().equals(UserType.ADMIN)) {
                request.getSession(false).setAttribute("isAdmin", true);
            }
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
        }

        return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
    }
}
