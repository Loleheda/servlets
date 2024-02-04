package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.COMMAND_SHOW_ADMIN_PANEL_PAGE;

public class BanUserCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        User user = DataBase.findUserByLogin(request.getParameter("login"));
        user.setBanned(!user.isBanned());
        return new RedirectResult(COMMAND_SHOW_ADMIN_PANEL_PAGE);
    }
}
