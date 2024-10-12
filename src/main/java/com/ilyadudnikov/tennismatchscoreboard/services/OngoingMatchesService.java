package com.ilyadudnikov.tennismatchscoreboard.services;

import com.ilyadudnikov.tennismatchscoreboard.exeptions.MatchNotFoundException;
import com.ilyadudnikov.tennismatchscoreboard.models.Match.Match;
import com.ilyadudnikov.tennismatchscoreboard.models.Player.Player;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class OngoingMatchesService {
    public static OngoingMatchesService instance;

    private final ConcurrentMap<UUID, Match> currentMatches = new ConcurrentHashMap<>();

    public UUID add(String player1Name, String player2Name) {
        Match match = createNewMatch(player1Name, player2Name);
        UUID uuid = UUID.randomUUID();
        currentMatches.put(uuid, match);
        return uuid;
    }

    private OngoingMatchesService() {
    }

    public static OngoingMatchesService getInstance() {
        if (instance == null) {
            synchronized (OngoingMatchesService.class) {
                if (instance == null) {
                    instance = new OngoingMatchesService();
                }
            }
        }
        return instance;
    }

    public Match createNewMatch(String player1Name, String player2Name) {
        Player player1 = PlayerService.createOrSelectByName(player1Name);
        Player player2 = PlayerService.createOrSelectByName(player2Name);
        Match match = new Match();
        match.setPlayer1(player1);
        match.setPlayer2(player2);
        return match;
    }

    public Match getCurrentMatch(UUID uuid) {
        Match currenMatch = currentMatches.get(uuid);
        if (currenMatch == null) {
            throw new MatchNotFoundException("Match with this uuid not found. UUID: " + uuid.toString());
        }

        return currenMatch;
    }

}
