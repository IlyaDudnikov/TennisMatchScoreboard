package com.ilyadudnikov.tennismatchscoreboard.dto;

import com.ilyadudnikov.tennismatchscoreboard.services.score.RegularGamePlayerPoints;
import lombok.Getter;

@Getter
public class GameScoreDto {
    RegularGamePlayerPoints player1Score;
    RegularGamePlayerPoints player2Score;

    public GameScoreDto (RegularGamePlayerPoints player1Score, RegularGamePlayerPoints player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }
}
