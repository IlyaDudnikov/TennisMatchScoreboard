package com.ilyadudnikov.tennismatchscoreboard.services;

import com.ilyadudnikov.tennismatchscoreboard.Config;
import com.ilyadudnikov.tennismatchscoreboard.dao.Impl.MatchDaoImpl;
import com.ilyadudnikov.tennismatchscoreboard.dao.MatchDao;
import com.ilyadudnikov.tennismatchscoreboard.models.Match.Match;

import java.util.List;

public class MatchPaginationService {
    private static final MatchDao matchDao = new MatchDaoImpl();

    public List<Match> getMatchesForPage(int pageNumber) {
        return matchDao.getAll(pageNumber);
    }

    public int getCountPagesForAllMatches() {
        long countAllMatches = matchDao.countAll();
        return (int) Math.ceil((double) countAllMatches / Config.MATCHES_PER_PAGE);
    }

    public List<Match> getMatchesByPlayerNameForPage(String playerName, int pageNumber) {
        return matchDao.getByPlayerName(playerName, pageNumber);
    }

    public int getCountPagesForMatchesByPlayerName(String playerName) {
        long countMatchesByPlayerName = matchDao.countByPlayerName(playerName);
        return (int) Math.ceil((double) countMatchesByPlayerName / Config.MATCHES_PER_PAGE);
    }
}
