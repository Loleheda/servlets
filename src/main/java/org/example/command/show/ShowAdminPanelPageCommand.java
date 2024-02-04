package org.example.command.show;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.data.UserType;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.Resources.PAGE_ADMIN_PANEL;

public class ShowAdminPanelPageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = DataBase.getUsers().values().stream()
                .filter(user -> !user.getUserType().equals(UserType.ADMIN)).collect(Collectors.toList());
        request.getSession(false).setAttribute("userAll", users);
        return new ForwardResult(PAGE_ADMIN_PANEL);
    }
}
