package com.romanbielyi.dao.impls;

import com.romanbielyi.dao.interfaces.CRUD;
import com.romanbielyi.entities.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorDao implements CRUD<Author> {

    private SessionFactory sessionFactory;

    @Autowired
    public AuthorDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Author findById(int id) {
        return sessionFactory.openSession().get(Author.class, id);
     }

    @Override
    public List<Author> findAll() {
        List<Author> authors = (List<Author>) sessionFactory.openSession().createQuery("From Author").list();
        return authors;
    }

    @Override
    public void save(Author author) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(author);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Author author) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(author);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Author author) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(author);
        transaction.commit();
        session.close();
    }
}
