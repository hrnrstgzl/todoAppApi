/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.DataAccess;

import com.hrnrstgzl.todoAppApi.Entities.TodoList;
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
public class HibernateTodoListDal implements ITodoListDal {

    private EntityManager entityManager;

    @Autowired
    public HibernateTodoListDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<TodoList> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from TodoList", TodoList.class).getResultList();
    }

    @Override
    public TodoList getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(TodoList.class, id);
    }

    @Override
    public List<TodoList> getByUserId(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from TodoList where user_id = " + id, TodoList.class).getResultList();
    }

    @Override
    public void add(TodoList todoList) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(todoList);
    }

    @Override
    public void update(TodoList todoList) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(todoList);
    }

    @Override
    public void delete(TodoList todoList) {
        Session session = entityManager.unwrap(Session.class);
        TodoList todoListToDelete = session.get(TodoList.class,todoList.getId());
        session.delete(todoListToDelete);
    }

}
