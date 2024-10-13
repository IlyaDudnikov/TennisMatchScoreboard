package com.ilyadudnikov.tennismatchscoreboard.models.Match;

import com.ilyadudnikov.tennismatchscoreboard.models.Player.Player;
import com.ilyadudnikov.tennismatchscoreboard.services.score.MatchScore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Matches")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Player1", referencedColumnName = "ID", nullable = false)
    private Player player1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Player2", referencedColumnName = "ID", nullable = false)
    private Player player2;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Winner", referencedColumnName = "ID", nullable = false)
    private Player winner;

    @Transient
    private MatchScore matchScore = new MatchScore();
}
