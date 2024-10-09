package com.ilyadudnikov.tennismatchscoreboard.services.score;

import java.util.ArrayList;
import java.util.List;

public abstract class Score<T> {
    private final List<T> playerScores = new ArrayList<>();

    protected abstract T getZeroScore();

    public Score() {
        playerScores.add(getZeroScore());
        playerScores.add(getZeroScore());
    }

    public T getPlayerScore(int playerNumber) {
        return playerScores.get(playerNumber);
    }

    public T getOpponentScore(int playerNumber) {
        return playerNumber == 1 ? playerScores.get(0) : playerScores.get(1);
    }

    public void setPlayerScore(int playerNumber, T playerScore) {
        playerScores.set(playerNumber, playerScore);
    }

    private void setOpponentScore(int playerNumber, T opponentScore) {
        int opponentNumber = playerNumber == 1 ? 0 : 1;
        playerScores.set(opponentNumber, opponentScore);
    }

    abstract State pointWon(int playerNumber);
}
