package com.ilyadudnikov.tennismatchscoreboard;

import com.ilyadudnikov.tennismatchscoreboard.exeptions.DatabaseException;
import lombok.Getter;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Создание конфигурации и настройка SessionFactory
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException e) {
            throw new DatabaseException("Ошибка при инициализации SessionFactory", e);
        }
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}

