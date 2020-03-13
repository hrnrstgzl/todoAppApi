/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.Business;

import com.hrnrstgzl.todoAppApi.DataAccess.ITodoItemDal;
import com.hrnrstgzl.todoAppApi.Entities.TodoItem;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Harun
 */
public interface ITodoItemService {
    List<TodoItem> getAll();
    
    TodoItem getById(int id);
    
    List<TodoItem> getByListId(int id);
    
    void add(TodoItem todoItem);

    void update(TodoItem todoItem);

    void delete(TodoItem todoItem);
}
