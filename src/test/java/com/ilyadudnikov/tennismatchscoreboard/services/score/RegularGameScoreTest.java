package com.ilyadudnikov.tennismatchscoreboard.services.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularGameScoreTest {
    private RegularGameScore regularGameScore;

    @BeforeEach
    public void init() {
        regularGameScore = new RegularGameScore();
    }

    @Test
    void FourPoint_WinGame() {
        for (int i = 0; i < 3; i++) {
            assertEquals(State.ONGOING, regularGameScore.pointWon(0));
        }

        assertEquals(State.PLAYER_ONE_WON, regularGameScore.pointWon(0));
    }

    @Test
    void FirstPlayerWinPointWhenScoreIs40ToAD_Score40To40() {
        regularGameScore.setPlayerScore(0, RegularGamePlayerPoints.FORTY);
        regularGameScore.setPlayerScore(1, RegularGamePlayerPoints.ADVANTAGE);

        assertEquals(State.ONGOING, regularGameScore.pointWon(0));

        RegularGamePlayerPoints firstPlayerScore = regularGameScore.getPlayerScore(0);
        RegularGamePlayerPoints secondPlayerScore = regularGameScore.getPlayerScore(1);

        assertEquals(RegularGamePlayerPoints.FORTY, firstPlayerScore);
        assertEquals(RegularGamePlayerPoints.FORTY, secondPlayerScore);
    }

    @Test
    void FirstPlayerWinPointWhenScoreIs40To40_ScoreADTo40() {
        regularGameScore.setPlayerScore(0, RegularGamePlayerPoints.FORTY);
        regularGameScore.setPlayerScore(1, RegularGamePlayerPoints.FORTY);

        assertEquals(State.ONGOING, regularGameScore.pointWon(0));

        RegularGamePlayerPoints firstPlayerScore = regularGameScore.getPlayerScore(0);
        RegularGamePlayerPoints secondPlayerScore = regularGameScore.getPlayerScore(1);

        assertEquals(RegularGamePlayerPoints.ADVANTAGE, firstPlayerScore);
        assertEquals(RegularGamePlayerPoints.FORTY, secondPlayerScore);
    }

}
