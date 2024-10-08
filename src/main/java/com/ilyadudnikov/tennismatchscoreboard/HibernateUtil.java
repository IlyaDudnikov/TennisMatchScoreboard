package com.ilyadudnikov.tennismatchscoreboard;

import com.ilyadudnikov.tennismatchscoreboard.exeptions.DatabaseException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Создание конфигурации и настройка SessionFactory
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            log.info("SessionFactory успешно создана и сконфигурирована");
            return sessionFactory;
        } catch (HibernateException e) {
            log.error("Ошибка при инициализации SessionFactory", e);
            throw new DatabaseException("Ошибка при инициализации SessionFactory", e);
        }
    }

    public static void shutdown() {
        try {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
            log.info("sessionFactory успешно закрыт");
        } catch (HibernateException e) {
            log.error("Ошибка при закрытии sessionFactory", e);
        }
    }
}

