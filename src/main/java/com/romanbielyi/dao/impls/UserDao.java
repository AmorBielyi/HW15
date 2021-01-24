package com.romanbielyi.dao.impls;

import com.romanbielyi.dao.interfaces.CRUD;
import com.romanbielyi.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao implements CRUD<User> {
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public UserDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public User findById(int id) {
        return sessionFactory.openSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        List<User> users = (List<User>) sessionFactory.openSession().createQuery("From User").list();
        return users;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }
}
