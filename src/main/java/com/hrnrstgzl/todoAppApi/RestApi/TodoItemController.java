/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.RestApi;

import com.hrnrstgzl.todoAppApi.Business.ITodoItemService;
import com.hrnrstgzl.todoAppApi.Entities.TodoItem;
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
@RestController
@CrossOrigin
@RequestMapping("/todoitem")
public class TodoItemController {
    ITodoItemService todoItemService;

    @Autowired
    public TodoItemController(ITodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }
    @GetMapping("/get")
    public List<TodoItem> get(@RequestParam(required = false) Integer listId){
        if(listId == null){
            return todoItemService.getAll();
        }else{
            return todoItemService.getByListId(listId);
        }
    }
    @GetMapping("/get/{id}")
    public TodoItem getById(@PathVariable int id){
        return this.todoItemService.getById(id);
    }
    
    @PostMapping("/add")
    public void add(@RequestBody TodoItem todoItem) {
        this.todoItemService.add(todoItem);
    }

    @PostMapping("/update")
    public void update(@RequestBody TodoItem todoItem) {
        this.todoItemService.update(todoItem);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody TodoItem todoItem) {
        this.todoItemService.delete(todoItem);
    }   
}
