/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.RestApi;

import com.hrnrstgzl.todoAppApi.Business.ITodoListService;
import com.hrnrstgzl.todoAppApi.Entities.TodoList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Harun
 */
@CrossOrigin
@RestController
@RequestMapping("/todolist")
public class TodoListController {
    ITodoListService todoListService;
    
    @Autowired
    public TodoListController(ITodoListService todoListService) {
        this.todoListService = todoListService;
    }
    @GetMapping("/get")
    public List<TodoList> get(@RequestParam(required = false) Integer userId){
        if(userId==null){
            return this.todoListService.getAll();
        }else{
            List<TodoList> listList =this.todoListService.getByUserId(userId);
            return listList;
        }
    }
    @GetMapping("/get/{id}")
    public TodoList getById(@PathVariable int id){
        return this.todoListService.getById(id);
    }
    
     @PostMapping("/add")
    public void add(@RequestBody TodoList todoList) {
        this.todoListService.add(todoList);
    }

    @PostMapping("/update")
    public void update(@RequestBody TodoList todoList) {
        this.todoListService.update(todoList);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody TodoList todoList) {
        this.todoListService.delete(todoList);
    }
    
}
