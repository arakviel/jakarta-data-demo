package com.arakviel.jakartadatademo.config;

import static org.hibernate.cfg.JdbcSettings.FORMAT_SQL;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;
import static org.hibernate.cfg.JdbcSettings.PASS;
import static org.hibernate.cfg.JdbcSettings.SHOW_SQL;
import static org.hibernate.cfg.JdbcSettings.URL;
import static org.hibernate.cfg.JdbcSettings.USER;

import com.arakviel.jakartadatademo.entity.Book;
import com.arakviel.jakartadatademo.repository.Library;
import com.arakviel.jakartadatademo.repository.Library_;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    StatelessSession statelessSession() {
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
              .addAnnotatedClass(Book.class)
              // use H2 in-memory database
              .setProperty(URL, "jdbc:postgresql://localhost/example")
              .setProperty(USER, "postgres")
              .setProperty(PASS, "")
              // display SQL in console
              .setProperty(SHOW_SQL, true)
              .setProperty(FORMAT_SQL, true)
              .setProperty(HIGHLIGHT_SQL, true)
              .setProperty("hibernate.hbm2ddl.auto", "update")
              .buildSessionFactory();

        // Повернення StatelessSession
        return sessionFactory.openStatelessSession();
    }

    @Bean
    Library library() {
        return new Library_(statelessSession());
    }
}
