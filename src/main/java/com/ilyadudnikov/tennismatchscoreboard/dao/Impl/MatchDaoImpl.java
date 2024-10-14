package com.ilyadudnikov.tennismatchscoreboard.dao.Impl;

import com.ilyadudnikov.tennismatchscoreboard.dao.MatchDao;
import com.ilyadudnikov.tennismatchscoreboard.exeptions.DatabaseException;
import com.ilyadudnikov.tennismatchscoreboard.models.Match.Match;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MatchDaoImpl implements MatchDao {
    public void save(Match match) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(match);
            transaction.commit();
        } catch (HibernateException e) {
            throw new DatabaseException("Ошибка сохранения в базу данных", e);
        }
    }
}
