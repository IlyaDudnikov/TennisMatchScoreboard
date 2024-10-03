package com.ilyadudnikov.tennismatchscoreboard.models.Match;

import com.ilyadudnikov.tennismatchscoreboard.models.Player.EPlayer;
import com.ilyadudnikov.tennismatchscoreboard.models.Player.PlayerScore;
import lombok.Data;

@Data
public class MatchScore {
    private PlayerScore player1Score;
    private PlayerScore player2Score;
    private boolean tieBreak;
    private EPlayer winner; // Геттер и сеттер будут сгенерированы

    public MatchScore() {
        player1Score = new PlayerScore();
        player2Score = new PlayerScore();
        tieBreak = false;
        winner = null;
    }
}
