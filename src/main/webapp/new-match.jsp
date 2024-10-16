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
<%@include file="errors.jsp"%>
<form class="new-match-form" action="${pageContext.request.contextPath}/new-match" method="post">
    <h1>СТРАНИЦА НОВЫХ МАТЧЕЙ</h1>

    <div class="inputs">
        <p>
            <label class="white-color" for="player1">Имя игрока 1</label><br>
            <input class="input-player-name" id="player1" type="text" name="player1Name" placeholder="Игрок 1" required
            value="<% if (request.getParameter("player1Name") != null &&
            !request.getParameter("player1Name").isBlank()) {
                out.println(request.getParameter("player1Name"));
            }%>">
        </p>

        <p>
            <label class="white-color" for="player2">Имя игрока 2</label><br>
            <input class="input-player-name" id="player2" type="text" name="player2Name" placeholder="Игрок 2" required
            value="<% if (request.getParameter("player2Name") != null &&
                !request.getParameter("player2Name").isBlank()) {
            out.println(request.getParameter("player2Name"));
        }%>">
        </p>
    </div>

    <button type="submit">Начать</button>
</form>

<div class="all-matches-button">
    <a href="${pageContext.request.contextPath}/matches">Все матчи</a>
</div>

</body>
</html>