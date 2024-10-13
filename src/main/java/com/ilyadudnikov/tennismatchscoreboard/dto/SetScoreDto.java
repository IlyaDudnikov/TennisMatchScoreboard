package com.ilyadudnikov.tennismatchscoreboard.dto;


import lombok.Getter;

@Getter
public class SetScoreDto extends ScoreDto<Integer> {
    public SetScoreDto(Integer player1Score, Integer player2Score) {
        super(player1Score, player2Score);
    }
//    Integer player1Score;
//    Integer player2Score;
//
//    public SetScoreDto(Integer player1Score, Integer player2Score) {
//        this.player1Score = player1Score;
//        this.player2Score = player2Score;
//    }
}
