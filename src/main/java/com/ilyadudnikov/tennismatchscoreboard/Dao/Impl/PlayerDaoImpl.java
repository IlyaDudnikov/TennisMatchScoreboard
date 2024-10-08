package com.ilyadudnikov.tennismatchscoreboard.Dao.Impl;

import com.ilyadudnikov.tennismatchscoreboard.Dao.PlayerDao;
import com.ilyadudnikov.tennismatchscoreboard.exeptions.DatabaseException;
import com.ilyadudnikov.tennismatchscoreboard.models.Player.Player;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class PlayerDaoImpl implements PlayerDao {
    @Override
    public Player save(String playerName) {
        Player player = Player.builder().name(playerName).build();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(player);
            transaction.commit();
        } catch (HibernateException e) {
            throw new DatabaseException("Ошибка добавления в базу данных", e);
        }
        return player;
    }

    @Override
    public Optional<Player> getByName(String playerName) {
        Player player;
        try (Session session = sessionFactory.openSession()) {
            player = session.get(Player.class, playerName);
        }
        return Optional.ofNullable(player);
    }
}
