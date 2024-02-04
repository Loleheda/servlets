package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.Message;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class SendMessageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        User sessionUser = (User) request.getSession(false).getAttribute("user");
        DataBase.getChat().addMessage(sessionUser, request.getParameter("messageInput"));
        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
