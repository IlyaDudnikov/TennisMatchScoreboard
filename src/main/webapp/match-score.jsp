<%--
  Created by IntelliJ IDEA.
  User: ilyad
  Date: 10/12/2024
  Time: 1:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.ilyadudnikov.tennismatchscoreboard.services.score.MatchScore" %>
<%@ page import="com.ilyadudnikov.tennismatchscoreboard.models.Match.Match" %>
<%@ page import="com.ilyadudnikov.tennismatchscoreboard.dto.SetScoreDto" %>
<%@ page import="com.ilyadudnikov.tennismatchscoreboard.dto.GameScoreDto" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Матч</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<% Match match = (Match) request.getAttribute("match"); %>
<% MatchScore matchScore = match.getMatchScore(); %>

<div class="container">
    <div class="tennisScoreboard">
        <h1 class="headTennis">Match</h1>
        <hr>
        <div class="flex-parent">
            <div class="previous-sets flex-column">
                <div class="head-column previous-sets-color">PREVIOUS SETS</div>
                <div class="flex-row all-available-space all-width">
                    <% for (int i = 0; i < 3; i++) {
                        SetScoreDto finishedSetScore = null;
                        if (matchScore.getFinishedSetScores().size() > i) {
                            finishedSetScore = matchScore.getFinishedSetScores().get(i);
                        }
                    %>
                        <div class="width33percents flex-column">

                            <div class="point-box all-available-space">
                                <span>
                                    <%= finishedSetScore != null ? finishedSetScore.getPlayer1Score() : ""  %>
                                </span>
                            </div>

                            <div class="point-box all-available-space">
                                <span>
                                    <%= finishedSetScore != null ? finishedSetScore.getPlayer2Score() : "" %>
                                </span>
                            </div>

                        </div>
                    <% } %>
                </div>
            </div>

            <div class="player flex-column">
                <div class="head-column player-color">PLAYER</div>
                <div class="all-available-space all-width flex-column">
                    <div class="player-name-box all-available-space"><span><%=match.getPlayer1().getName()%></span></div>
                    <div class="player-name-box all-available-space"><span><%=match.getPlayer2().getName()%></span></div>
                </div>
            </div>

            <div class="set flex-column">
                <div class="head-column set-color">SET</div>
                <div class="all-available-space all-width flex-column">
                    <% SetScoreDto currentSetScore = matchScore.getCurrentSetScore(); %>
                    <div class="point-box all-available-space"><span><%=currentSetScore.getPlayer1Score()%></span></div>
                    <div class="point-box all-available-space"><span><%=currentSetScore.getPlayer2Score()%></span></div>
                </div>
            </div>

            <div class="points flex-column">
                <div class="head-column points-color">POINTS</div>
                <div class="all-available-space all-width flex-column">
                    <% GameScoreDto currentGameScore = matchScore.getCurrentGameScore(); %>
                    <div class="point-box all-available-space"><span><%=currentGameScore.getPlayer1Score()%></span></div>
                    <div class="point-box all-available-space"><span><%=currentGameScore.getPlayer2Score()%></span></div>
                </div>
            </div>

            <div class="point-buttons flex-column">
                <% if (match.getWinner() == null) { %>
                    <div class="indentation"></div>
                    <div class="all-available-space all-width flex-column flex-space-around">
                        <form class="form-won-point" action="${pageContext.request.contextPath}/match-score" method="post">
                            <input type="hidden" name="id" value="<%=match.getPlayer1().getId()%>">
                            <button class="button-won-point" type="submit">Player 1<br> won point</button>
                        </form>

                        <form class="form-won-point" action="${pageContext.request.contextPath}/new-match">
                            <input type="hidden" name="id" value="<%=match.getPlayer2().getId()%>">
                            <button type="submit" class="button-won-point">Player 2<br> won point</button>
                        </form>
                    </div>
                <% } %>
            </div>
        </div>
    </div>

    <% if (match.getWinner() != null) { %>
        <div class="match-finish-block">
            <hr class="remove-top-margin">
            <div class="winner">WINNER</div>
            <div class="player-winner"><%=match.getWinner().getName()%></div>
            <a class="continue-button" href="#">CONTINUE</a>
        </div>
    <% } %>

</div>
</body>
</html>
