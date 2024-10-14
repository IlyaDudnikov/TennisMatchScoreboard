package com.ilyadudnikov.tennismatchscoreboard.dao;

import com.ilyadudnikov.tennismatchscoreboard.HibernateUtil;
import com.ilyadudnikov.tennismatchscoreboard.models.Match.Match;
import org.hibernate.SessionFactory;

public interface MatchDao {
     SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
     void save(Match match);
}
