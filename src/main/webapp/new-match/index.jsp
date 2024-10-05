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
<h1>Страница новых матчей</h1>
<form action="${pageContext.request.contextPath}/new-match" method="post">
    <label for="player1">Имя игрока 1</label>
    <input id="player1" type="text" name="player1" required>

    <label for="player2">Имя игрока 2</label>
    <input id="player2" type="text" name="player2" required>

    <button type="submit">Начать</button>
</form>

</body>

</html>