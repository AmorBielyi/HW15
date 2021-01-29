package com.romanbielyi.dao.impls;

import com.romanbielyi.dao.interfaces.CRUD;
import com.romanbielyi.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDao implements CRUD<Book> {
    private SessionFactory sessionFactory;

    @Autowired
    public BookDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Book findById(int id) {
        return sessionFactory.openSession().get(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = (List<Book>) sessionFactory.openSession().createQuery("From Book").list();
        return books;
    }

    @Override
    public void save(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();
        session.close();
    }
}
