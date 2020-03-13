/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.DataAccess;

import com.hrnrstgzl.todoAppApi.Entities.TodoItem;
import java.util.List;

/**
 *
 * @author Harun
 */
public interface ITodoItemDal {
    List<TodoItem> getAll();
    
    TodoItem getById(int id);
    
    List<TodoItem> getByListId(int id);
    
    void add(TodoItem todoItem);

    void update(TodoItem todoItem);

    void delete(TodoItem todoItem);
    
}
