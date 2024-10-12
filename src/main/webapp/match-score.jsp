<%--
  Created by IntelliJ IDEA.
  User: ilyad
  Date: 10/12/2024
  Time: 1:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Матч</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <div class="tennisScoreboard">
        <h1 class="headTennis">Match</h1>
        <hr>
        <div class="flex-parent">
            <div class="previous-sets flex-column">
                <div class="head-column previous-sets-color">PREVIOUS SETS</div>
                <div class="flex-row all-available-space all-width">
                    <div class="width33percents flex-column">
                        <div class="point-box all-available-space"><span>
                        </span></div>
                        <div class="point-box all-available-space"><span>6</span></div>
                    </div>
                    <div class="all-available-space flex-column">
                        <div class="point-box all-available-space"><span></span></div>
                        <div class="point-box all-available-space"><span></span></div>
                    </div>
                    <div class="all-available-space flex-column">
                        <div class="point-box all-available-space"><span></span></div>
                        <div class="point-box all-available-space"><span></span></div>
                    </div>
                </div>
            </div>

            <div class="player flex-column">
                <div class="head-column player-color">PLAYER</div>
                <div class="all-available-space all-width flex-column">
                    <div class="player-name-box all-available-space"><span>First player</span></div>
                    <div class="player-name-box all-available-space"><span>Voroshilkov Konstanitn</span></div>
                </div>
            </div>

            <div class="set flex-column">
                <div class="head-column set-color">SET</div>
                <div class="all-available-space all-width flex-column">
                    <div class="point-box all-available-space"><span>5</span></div>
                    <div class="point-box all-available-space"><span>6</span></div>
                </div>
            </div>

            <div class="points flex-column">
                <div class="head-column points-color">POINTS</div>
                <div class="all-available-space all-width flex-column">
                    <div class="point-box all-available-space"><span>AD</span></div>
                    <div class="point-box all-available-space"><span>6</span></div>
                </div>
            </div>

            <div class="point-buttons flex-column">
                <div class="indentation"></div>
                <div class="all-available-space all-width flex-column flex-space-around">
                    <a href="#" class="button-won-point">Player 1<br> won point</a>
                    <a href="#" class="button-won-point">Player 2<br> won point</a>
                </div>
            </div>
        </div>
    </div>

    <div class="match-finish-block">
        <hr class="remove-top-margin">
        <div class="winner">WINNER</div>
        <div class="player-winner">Player Winner</div>
        <a class="continue-button" href="#">CONTINUE</a>
    </div>

</div>
</body>
</html>
