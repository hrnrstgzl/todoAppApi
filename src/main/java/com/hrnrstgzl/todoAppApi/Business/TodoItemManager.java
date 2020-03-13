/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.Business;

import com.hrnrstgzl.todoAppApi.DataAccess.ITodoItemDal;
import com.hrnrstgzl.todoAppApi.Entities.TodoItem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Harun
 */
@Service
public class TodoItemManager implements ITodoItemService{

    ITodoItemDal todoItemDal;
    @Autowired
    public TodoItemManager(ITodoItemDal todoItemDal) {
        this.todoItemDal = todoItemDal;
    }
    
    
    @Override
    @Transactional
    public List<TodoItem> getAll() {
        return this.todoItemDal.getAll();
    }

    @Override
    @Transactional
    public TodoItem getById(int id) {
        return this.todoItemDal.getById(id);
    }

    @Override
    @Transactional
    public List<TodoItem> getByListId(int id) {
        return this.todoItemDal.getByListId(id);
    }

    @Override
    @Transactional
    public void add(TodoItem todoItem) {
        this.todoItemDal.add(todoItem);
    }

    @Override
    @Transactional
    public void update(TodoItem todoItem) {
        this.todoItemDal.update(todoItem);
    }

    @Override
    @Transactional
    public void delete(TodoItem todoItem) {
        this.todoItemDal.delete(todoItem);
    }
    
}
