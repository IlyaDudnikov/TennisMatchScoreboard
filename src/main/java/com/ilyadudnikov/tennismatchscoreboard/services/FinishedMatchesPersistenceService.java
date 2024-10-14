package com.ilyadudnikov.tennismatchscoreboard.services;

import com.ilyadudnikov.tennismatchscoreboard.dao.Impl.MatchDaoImpl;
import com.ilyadudnikov.tennismatchscoreboard.dao.MatchDao;
import com.ilyadudnikov.tennismatchscoreboard.models.Match.Match;

public class FinishedMatchesPersistenceService {
    private static final MatchDao matchDao = new MatchDaoImpl();
    public static void save(Match match) {
        matchDao.save(match);
    }
}
