package com.ilyadudnikov.tennismatchscoreboard.services.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetScoreTest {
    private SetScore setScore;

    @BeforeEach
    public void init() {
        setScore = new SetScore();
    }

    @Test
    void TwentyFourPoint_WinSet() {
        for (int i = 0; i < 23; i++) {
            assertEquals(State.ONGOING, setScore.pointWon(0));
        }

        assertEquals(State.PLAYER_ONE_WON, setScore.pointWon(0));
    }

    @Test
    void Score6To6_StartTieBreak() {
        // 5:6
        setScore.setPlayerScore(0, 5);
        setScore.setPlayerScore(1, 6);

        // return score 6:6
        for (int i = 0; i < 4; i++) {
            setScore.pointWon(0);
        }

        // start tie-break
        // return 6:0
        for (int i = 0; i < 6; i++) {
            assertEquals(State.ONGOING, setScore.pointWon(0));
        }

        // return 6:6
        for (int i = 0; i < 6; i++) {
            assertEquals(State.ONGOING, setScore.pointWon(1));
        }

        // return 7:6
        assertEquals(State.ONGOING, setScore.pointWon(0));

        // return 7:8
        assertEquals(State.ONGOING, setScore.pointWon(1));
        assertEquals(State.ONGOING, setScore.pointWon(1));

        // return 10:8
        // first player win tie-break and set
        assertEquals(State.ONGOING, setScore.pointWon(0));
        assertEquals(State.ONGOING, setScore.pointWon(0));
        assertEquals(State.PLAYER_ONE_WON, setScore.pointWon(0));
    }
}
