package com.ilyadudnikov.tennismatchscoreboard.services;

import com.ilyadudnikov.tennismatchscoreboard.models.Match.Match;
import com.ilyadudnikov.tennismatchscoreboard.services.score.State;

public class MatchScoreCalculationService {
    public static void updateScore(Match match, long idPlayerWhoWonPoint) {
        int numberPlayerWhoWonPoint;
        if (idPlayerWhoWonPoint == match.getPlayer1().getId()) {
            numberPlayerWhoWonPoint = 0;
        } else if (idPlayerWhoWonPoint == match.getPlayer2().getId()) {
            numberPlayerWhoWonPoint = 1;
        } else {
            throw new IllegalArgumentException("This id does not belong to any of the players:" + idPlayerWhoWonPoint);
        }
        
        State matchState = match.getMatchScore().pointWon(numberPlayerWhoWonPoint);
        if (matchState == State.PLAYER_ONE_WON) {
            match.setWinner(match.getPlayer1());
        } else if (matchState == State.PLAYER_TWO_WON) {
            match.setWinner(match.getPlayer2());
        }


    }
}
