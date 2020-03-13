/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.DataAccess;

import com.hrnrstgzl.todoAppApi.Entities.TodoItem;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Harun
 */
@Repository
public class HibernateTodoItemDal implements ITodoItemDal{
    
    private EntityManager entityManager;
    @Autowired
    public HibernateTodoItemDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    

    @Override
    public List<TodoItem> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from TodoItem",TodoItem.class).getResultList();
    }
    
    @Override
    public TodoItem getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(TodoItem.class,id);
    }

    @Override
    public List<TodoItem> getByListId(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from TodoItem where list_id = " + id ,TodoItem.class).getResultList();
    }
    

    @Override
    public void add(TodoItem todoItem) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(todoItem);
    }

    @Override
    public void update(TodoItem todoItem) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(todoItem);
    }

    @Override
    public void delete(TodoItem todoItem) {
        Session session = entityManager.unwrap(Session.class);
        TodoItem todoItemtToDelete = session.get(TodoItem.class,todoItem.getId());
        session.delete(todoItemtToDelete);
    }

    
}
