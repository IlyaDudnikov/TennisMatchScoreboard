package com.ilyadudnikov.tennismatchscoreboard.dao.Impl;

import com.ilyadudnikov.tennismatchscoreboard.Config;
import com.ilyadudnikov.tennismatchscoreboard.dao.MatchDao;
import com.ilyadudnikov.tennismatchscoreboard.exeptions.DatabaseException;
import com.ilyadudnikov.tennismatchscoreboard.models.Match.Match;
import com.ilyadudnikov.tennismatchscoreboard.models.Player.Player;
import jakarta.persistence.criteria.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MatchDaoImpl implements MatchDao {
    @Override
    public void save(Match match) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(match);
            transaction.commit();
        } catch (HibernateException e) {
            throw new DatabaseException("Ошибка сохранения в базу данных", e);
        }
    }

    @Override
    public List<Match> getAll(int pageNumber) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Match> query = builder.createQuery(Match.class);
            Root<Match> root = query.from(Match.class);
            query.select(root);
            Query<Match> q = session.createQuery(query);

            q.setFirstResult((pageNumber - 1) * Config.MATCHES_PER_PAGE);
            q.setMaxResults(Config.MATCHES_PER_PAGE);
            return q.getResultList();
        } catch (HibernateException e) {
            throw new DatabaseException("Ошибка поиска всех матчей", e);
        }
    }

    @Override
    public long countAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
            Root<Match> root = countQuery.from(Match.class);
            countQuery.select(builder.count(root));

            Query<Long> q = session.createQuery(countQuery);
            return q.getSingleResult();
        } catch (HibernateException e) {
            throw new DatabaseException("Ошибка при получении количества всех матчей", e);
        }
    }

    @Override
    public List<Match> getByPlayerName(String playerName, int pageNumber) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Match> query = builder.createQuery(Match.class);
            Root<Match> root = query.from(Match.class);
            query.select(root);

            Join<Match, Player> player1Join = root.join("player1");
            Join<Match, Player> player2Join = root.join("player2");

            Predicate player1Predicate = builder.equal(player1Join.get("name"), playerName);
            Predicate player2Predicate = builder.equal(player2Join.get("name"), playerName);
            query.where(builder.or(player1Predicate, player2Predicate));

            Query<Match> q = session.createQuery(query);
            q.setFirstResult((pageNumber - 1) * Config.MATCHES_PER_PAGE);
            q.setMaxResults(Config.MATCHES_PER_PAGE);

            return q.getResultList();
        }
    }

    @Override
    public long countByPlayerName(String playerName) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
            Root<Match> root = countQuery.from(Match.class);

            Join<Match, Player> player1Join = root.join("player1");
            Join<Match, Player> player2Join = root.join("player2");

            Predicate player1Predicate = builder.equal(player1Join.get("name"), playerName);
            Predicate player2Predicate = builder.equal(player2Join.get("name"), playerName);
            countQuery.select(builder.count(root)).where(builder.or(player1Predicate, player2Predicate));

            Query<Long> query = session.createQuery(countQuery);
            return query.getSingleResult();
        }
    }

}
