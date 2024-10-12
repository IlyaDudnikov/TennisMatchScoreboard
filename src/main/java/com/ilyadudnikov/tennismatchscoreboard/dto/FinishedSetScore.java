package com.ilyadudnikov.tennismatchscoreboard.dto;


import lombok.Getter;

@Getter
public class FinishedSetScore {
    Integer player1Score;
    Integer player2Score;

    public FinishedSetScore(Integer player1Score, Integer player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }
}
