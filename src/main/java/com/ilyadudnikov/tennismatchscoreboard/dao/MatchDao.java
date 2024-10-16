package com.ilyadudnikov.tennismatchscoreboard.dao;

import com.ilyadudnikov.tennismatchscoreboard.HibernateUtil;
import com.ilyadudnikov.tennismatchscoreboard.models.Match.Match;
import org.hibernate.SessionFactory;

import java.util.List;

public interface MatchDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    void save(Match match);

    List<Match> getAll(int pageNumber);
    long countAll();

    List<Match> getByPlayerName(String playerName, int pageNumber);

    long countByPlayerName(String playerName);
}
