package com.ilyadudnikov.tennismatchscoreboard.services.score;

public class TieBreakScore extends Score<Integer> {

    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    State pointWon(int playerNumber) {
        setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);
        Integer playerScore = getPlayerScore(playerNumber);

        if (playerScore < 7) {
            return State.ONGOING;
        } else {
            Integer opponentScore = getOpponentScore(playerNumber);

            if ((playerScore - opponentScore) >= 2) {
                return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
            } else {
                return State.ONGOING;
            }
        }
    }
}
