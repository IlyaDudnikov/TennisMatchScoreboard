package com.ilyadudnikov.tennismatchscoreboard.services;

import com.ilyadudnikov.tennismatchscoreboard.Dao.Impl.PlayerDaoImpl;
import com.ilyadudnikov.tennismatchscoreboard.exeptions.DatabaseException;
import com.ilyadudnikov.tennismatchscoreboard.models.Player.Player;

public class PlayerService {
    private static final PlayerDaoImpl playerDao = new PlayerDaoImpl();
    public static Player createOrSelectByName(String playerName) {
        Player player;
        try {
            player = playerDao.save(playerName);
        } catch (DatabaseException e) {
            player = playerDao.getByName(playerName).get();
        }
        return player;
    }
}
