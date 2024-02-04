package org.example.command;

import org.example.command.action.BanUserCommand;
import org.example.command.action.LoginCommand;
import org.example.command.action.LogoutCommand;
import org.example.command.action.SendMessageCommand;
import org.example.command.show.ShowAdminPanelPageCommand;
import org.example.command.show.ShowChatPageCommand;
import org.example.command.show.ShowLoginPageCommand;

public enum CommandType {
    EMPTY(new EmptyCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    SEND_MESSAGE(new SendMessageCommand()),
    BAN_USER(new BanUserCommand()),

    SHOW_CHAT_PAGE(new ShowChatPageCommand()),
    SHOW_LOGIN_PAGE(new ShowLoginPageCommand()),
    SHOW_ADMIN_PANEL_PAGE(new ShowAdminPanelPageCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
