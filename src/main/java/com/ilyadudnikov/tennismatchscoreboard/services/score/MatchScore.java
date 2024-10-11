package com.ilyadudnikov.tennismatchscoreboard.services.score;

public class MatchScore extends Score<Integer> {
    private SetScore currentSet = new SetScore();

    @Override
    protected Integer getZeroScore() {
        return 0;
    }

    @Override
    public State pointWon(int playerNumber) {
        State setState = currentSet.pointWon(playerNumber);

        if (setState.ordinal() == State.PLAYER_ONE_WON.ordinal()) {
            return setWon(0);
        } else if (setState.ordinal() == State.PLAYER_TWO_WON.ordinal()) {
            return setWon(1);
        }

        return State.ONGOING;
    }

    private State setWon(int playerNumber) {
        currentSet = new SetScore();

        setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);
        if (getPlayerScore(playerNumber) == 2) {
            return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
        }

        return State.ONGOING;
    }
}
