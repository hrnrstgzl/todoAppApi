/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.DataAccess;

import com.hrnrstgzl.todoAppApi.Entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Harun
 */
@Repository
public class HibernateUserDal implements IUserDal {
    
    EntityManager entityManager;

    @Autowired
    public HibernateUserDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from User",User.class).getResultList();
    }

    @Override
    public User getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class,id);
    }

    @Override
    public User getByEmail(String email) {
        User user = null;
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from User where email = :emailParam", User.class);
        query.setParameter("emailParam",email);
        List<User> userList = query.getResultList();
        if(userList.size()>0) {
            user = userList.get(0);
        }
        return user;
    }

    @Override
    public void add(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public void update(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        Session session = entityManager.unwrap(Session.class);
        User UserToDelete = session.get(User.class,user.getId());
        session.delete(UserToDelete);
            
    }
    
}
