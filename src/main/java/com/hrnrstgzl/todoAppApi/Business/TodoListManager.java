/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.Business;

import com.hrnrstgzl.todoAppApi.DataAccess.ITodoListDal;
import com.hrnrstgzl.todoAppApi.Entities.TodoList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Harun
 */
@Service
public class TodoListManager implements ITodoListService{

    ITodoListDal todoListDal;
    @Autowired
    public TodoListManager(ITodoListDal todoListDal) {
        this.todoListDal = todoListDal;
    }
    
    
    @Override
    @Transactional
    public List<TodoList> getAll() {
        return this.todoListDal.getAll();
    }

    @Override
    @Transactional
    public TodoList getById(int id) {
        return this.todoListDal.getById(id);
    }

    @Override
    @Transactional
    public List<TodoList> getByUserId(int id) {
        return this.todoListDal.getByUserId(id);
    }

    @Override
    @Transactional
    public void add(TodoList todoList) {
        this.todoListDal.add(todoList);
    }

    @Override
    @Transactional
    public void update(TodoList todoList) {
        this.todoListDal.update(todoList);
    }

    @Override
    @Transactional
    public void delete(TodoList todoList) {
        this.todoListDal.delete(todoList);
    }
    
}
