package com.ilyadudnikov.tennismatchscoreboard.Dao;

import com.ilyadudnikov.tennismatchscoreboard.HibernateUtil;
import com.ilyadudnikov.tennismatchscoreboard.models.Player.Player;
import org.hibernate.SessionFactory;

import java.util.Optional;

public interface PlayerDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Player save(String playerName);
    Optional<Player> getByName(String playerName);
}
