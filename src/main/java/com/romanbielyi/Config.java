package com.romanbielyi;

import com.romanbielyi.entities.Author;
import com.romanbielyi.entities.Book;
import com.romanbielyi.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.romanbielyi")
public class Config {

    @Bean
    SessionFactory getSessionFactory(){
        SessionFactory sessionFactory = null;
        try{
            org.hibernate.cfg.Configuration configuration =
                    new org.hibernate.cfg.Configuration().configure();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Author.class);
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }catch(Exception e){
            System.out.println("Exception " + e);
        }
        return sessionFactory;
    }

}
