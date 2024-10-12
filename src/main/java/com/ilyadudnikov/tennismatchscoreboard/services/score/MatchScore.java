package com.ilyadudnikov.tennismatchscoreboard.services.score;

import com.ilyadudnikov.tennismatchscoreboard.dto.FinishedSetScore;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class MatchScore extends Score<Integer> {
    private SetScore currentSet = new SetScore();
    @Getter
    private final List<FinishedSetScore> finishedSetScores = new ArrayList<>();

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
        addSetScoreToFinishedSetScore(currentSet);

        currentSet = new SetScore();

        setPlayerScore(playerNumber, getPlayerScore(playerNumber) + 1);
        if (getPlayerScore(playerNumber) == 2) {
            return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
        }

        return State.ONGOING;
    }

    void addSetScoreToFinishedSetScore(SetScore setScore) {
        FinishedSetScore finishedSetScore = new FinishedSetScore(
                setScore.getPlayerScore(0),
                setScore.getPlayerScore(1)
        );
        finishedSetScores.add(finishedSetScore);
    }
}
