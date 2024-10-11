package com.ilyadudnikov.tennismatchscoreboard.services.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchScoreTest {
    private MatchScore matchScore;

    @BeforeEach
    public void init() {
        matchScore = new MatchScore();
    }

    @Test
    void FortyEightPoints_WinMatch() {
        for (int i = 0; i < 47; i++) {
            assertEquals(State.ONGOING, matchScore.pointWon(0));
        }

        assertEquals(State.PLAYER_ONE_WON, matchScore.pointWon(0));
    }

    @Test
    void ScoreIs1To1_StartThirdSet() {
        // 0:0
        // return 1:0
        for (int i = 0; i < 24; i++) {
            assertEquals(State.ONGOING, matchScore.pointWon(0));
        }

        // return 1:1
        for (int i = 0; i < 24; i++) {
            assertEquals(State.ONGOING, matchScore.pointWon(1));
        }

        // start 3 set
        for (int i = 0; i < 23; i++) {
            assertEquals(State.ONGOING, matchScore.pointWon(0));
        }
        assertEquals(State.PLAYER_ONE_WON, matchScore.pointWon(0));
    }
}
