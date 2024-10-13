package com.ilyadudnikov.tennismatchscoreboard.dto;

public class TieBreakScoreDto extends ScoreDto<Integer> {
    public TieBreakScoreDto(Integer player1Score, Integer player2Score) {
        super(player1Score, player2Score);
    }
}
