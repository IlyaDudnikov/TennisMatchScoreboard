package com.ilyadudnikov.tennismatchscoreboard.models.Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerScore {
    private int points;
    private int games;
    private int sets;
    private int tieBreakPoints;
}
