<%--
  Created by IntelliJ IDEA.
  User: ilyad
  Date: 10/4/2024
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Форма для новых матчей</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<form class="new-match-form" action="${pageContext.request.contextPath}/new-match" method="post">
    <h1>СТРАНИЦА НОВЫХ МАТЧЕЙ</h1>

    <div class="inputs">
        <p>
            <label class="white-color" for="player1">Имя игрока 1</label><br>
            <input id="player1" type="text" name="player1" placeholder="Игрок 1" required
            value="<% if (request.getParameter("player1") != null &&
            !request.getParameter("player1").isBlank()) {
                out.println(request.getParameter("player1"));
            }%>">
        </p>

        <p>
            <label class="white-color" for="player2">Имя игрока 2</label><br>
            <input id="player2" type="text" name="player2" placeholder="Игрок 2" required
            value="<% if (request.getParameter("player2") != null &&
                !request.getParameter("player2").isBlank()) {
            out.println(request.getParameter("player2"));
        }%>">
        </p>
    </div>

    <button type="submit">Начать</button>
</form>
</body>
</html>