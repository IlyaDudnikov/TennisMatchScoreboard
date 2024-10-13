package com.ilyadudnikov.tennismatchscoreboard.services.score;

import com.ilyadudnikov.tennismatchscoreboard.dto.GameScoreDto;

public class SetScore extends Score<Integer> {

    private RegularGameScore currentGame = new RegularGameScore();
    private boolean tieBreak = false;
    private TieBreakScore currentTieBreak;

    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    public State pointWon(int playerNumber) {
        if (tieBreak) {
            return pointWonInTieBreak(playerNumber);
        }

        return pointWonInGame(playerNumber);
    }

    private State pointWonInGame(int playerNumber) {
        State gameState = currentGame.pointWon(playerNumber);

        if (gameState.ordinal() == State.PLAYER_ONE_WON.ordinal()) {
            return gameWon(0);
        } else if (gameState.ordinal() == State.PLAYER_TWO_WON.ordinal()) {
            return gameWon(1);
        }

        return State.ONGOING;
    }

    private State pointWonInTieBreak(int playerNumber) {
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

    private State gameWon(int playerNumber) {
        currentGame = new RegularGameScore();

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

    public GameScoreDto getCurrentGameScore() {
        RegularGamePlayerPoints scorePlayer1InCurrentGame = currentGame.getPlayerScore(0);
        RegularGamePlayerPoints scorePlayer2InCurrentGame = currentGame.getPlayerScore(1);

        return new GameScoreDto(scorePlayer1InCurrentGame, scorePlayer2InCurrentGame);
    }
}
