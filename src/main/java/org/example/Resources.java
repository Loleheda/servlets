package org.example;

public final class Resources {

    public static final String PAGE_LOGIN = "/WEB-INF/jsp/login.jsp";
    public static final String PAGE_CHAT = "/WEB-INF/jsp/chat.jsp";
    public static final String PAGE_ADMIN_PANEL = "/WEB-INF/jsp/adminPanel.jsp";

    public static final String COMMAND_SHOW_LOGIN_PAGE = "chat?command=show_login_page";
    public static final String COMMAND_SHOW_CHAT_PAGE = "chat?command=show_chat_page";
    public static final String COMMAND_SHOW_ADMIN_PANEL_PAGE = "chat?command=show_admin_panel_page";

    private Resources() {
    }
}
