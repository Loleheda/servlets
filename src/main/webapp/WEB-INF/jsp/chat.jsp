<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Чат</title>
    </head>
    <body>
        <div class="chat" align="center">
            <a href="chat?command=logout">Выход</a>
            <c:if test = "${isAdmin}">
                <a href="chat?command=show_admin_panel_page">Панель администратора</a>
            </c:if>
            <div class="massages">
                <table>
                    <caption>Чат</caption>
                    <tr>
                        <th><b>Имя</b></th>
                        <th><b>Сообщение</b></th>
                    </tr>
                    <c:forEach var="massage" items="${massages}">
                        <tr>
                            <td><i>${massage.getUser().getName()}</i></td>
                            <td>${massage.getMassage()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <c:if test = "${!user.isBanned() && !isAdmin}">
                <div class="sendMessage">
                    <form action="chat?command=send_message" method="post">
                        <input id="messageInput" type="text" placeholder="Введите текст..." name="messageInput"/>
                        <button type="submit">Отправить</button>
                    </form>
                </div>
            </c:if>
        </div>
    </body>
</html>