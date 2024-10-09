package com.ilyadudnikov.tennismatchscoreboard.services.score;

public class SetScore extends Score<Integer> {

    RegularGameScore currentGame = new RegularGameScore();
    boolean tieBreak = false;
    TieBreakScore currentTieBreak;

    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    State pointWon(int playerNumber) {
        if (tieBreak) {
            return pointWonInTieBreak(playerNumber);
        }

        return pointWonInGame(playerNumber);
    }

    State pointWonInGame(int playerNumber) {
        State gameState = currentGame.pointWon(playerNumber);

        if (gameState.ordinal() == State.PLAYER_ONE_WON.ordinal()) {
            return gameWon(0);
        } else if (gameState.ordinal() == State.PLAYER_TWO_WON.ordinal()) {
            return gameWon(1);
        }

        return State.ONGOING;
    }

    State pointWonInTieBreak(int playerNumber) {
        State tieBreakState = currentTieBreak.pointWon(playerNumber);

        if (tieBreakState.ordinal() == State.PLAYER_ONE_WON.ordinal()) {
            setPlayerScore(0, 7);
            return State.PLAYER_ONE_WON;
        } else if (tieBreakState.ordinal() == State.PLAYER_TWO_WON.ordinal()) {
            setPlayerScore(1, 7);
            return State.PLAYER_TWO_WON;
        }

        return State.ONGOING;
    }

    State gameWon(int playerNumber) {
        setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);
        Integer playerScore = getPlayerScore(playerNumber);

        if (playerScore == 7) {
            return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
        } else if (playerScore == 6) {
            Integer opponentScore = getOpponentScore(playerNumber);

            if (opponentScore <= 4) {
                return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
            } else if (opponentScore == 5) {
                return State.ONGOING;
            } else if (opponentScore == 6) {
                tieBreak = true;
                currentTieBreak = new TieBreakScore();
                return State.ONGOING;
            }
        }

        return State.ONGOING;
    }
}
