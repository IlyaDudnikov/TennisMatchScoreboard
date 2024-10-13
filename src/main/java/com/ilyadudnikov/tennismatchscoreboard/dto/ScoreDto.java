package com.ilyadudnikov.tennismatchscoreboard.dto;

import lombok.Getter;

@Getter
public abstract class ScoreDto<T> {
    private T player1Score;
    private T player2Score;

    public ScoreDto(T player1Score, T player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }
}
