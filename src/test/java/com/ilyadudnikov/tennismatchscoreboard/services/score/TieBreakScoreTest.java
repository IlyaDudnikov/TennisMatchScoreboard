package com.ilyadudnikov.tennismatchscoreboard.services.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TieBreakScoreTest {
    private TieBreakScore tiebreakScore;

    @BeforeEach
    public void init() {
        tiebreakScore = new TieBreakScore();
    }

    @Test
    void SevenPoint_WinTieBreak() {
        for (int i = 0; i < 6; i++) {
            assertEquals(State.ONGOING, tiebreakScore.pointWon(0));
        }

        assertEquals(State.PLAYER_ONE_WON, tiebreakScore.pointWon(0));
    }

    @Test
    void FirstPlayerWinPointWhenScoreIs6To6_TieBreakOngoing() {
        tiebreakScore.setPlayerScore(0, 6);
        tiebreakScore.setPlayerScore(1, 6);

        assertEquals(State.ONGOING, tiebreakScore.pointWon(0));
    }

    @Test
    void FirsPlayerWinPointWhenScoreIs11To10_FirstPlayerWinTieBreak() {
        tiebreakScore.setPlayerScore(0, 11);
        tiebreakScore.setPlayerScore(1, 10);

        assertEquals(State.PLAYER_ONE_WON, tiebreakScore.pointWon(0));
    }
}
