/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.Business;

import com.hrnrstgzl.todoAppApi.Entities.TodoList;
import java.util.List;

/**
 *
 * @author Harun
 */
public interface ITodoListService {
    List<TodoList> getAll();
    
    TodoList getById(int id);
    
    List<TodoList> getByUserId(int id);
    
    void add(TodoList todoList);

    void update(TodoList todoList);

    void delete(TodoList todoList);
}
