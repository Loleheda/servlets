<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Панель администратора</title>
</head>
<body>
    <div class="panel" align="center">
        <a href="chat?command=show_chat_page">Страница чата</a>
        <table>
        <caption>Таблица пользователей</caption>
        <tr>
            <th><b>Логин</b><br></th>
            <th><b>Онлайн</b><br></th>
            <th><b>Достап к отправке сообщения</b><br></th>
        </tr>
        <c:forEach var="user" items="${userAll}">
            <tr>
                <td>${user.getLogin()}</td>
                <td>${user.isOnline()}</td>
                <td>${user.isBanned()}</td>
                <td>
                    <form action="chat?command=ban_user" method="post">
                        <input type="hidden" name="login" value="${user.getLogin()}"/>
                        <button type="submit">
                            <c:choose>
                                <c:when test = "${user.isBanned()}">
                                    Разбанить
                                </c:when>

                                <c:when test = "${!user.isBanned()}">
                                    Забанить
                                </c:when>
                            </c:choose>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </table>
    </div>

</body>
</html>
