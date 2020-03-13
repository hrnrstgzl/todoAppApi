/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.RestApi;

import com.hrnrstgzl.todoAppApi.Business.IUserService;
import com.hrnrstgzl.todoAppApi.Entities.User;
import java.util.ArrayList;
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
@RequestMapping("/user")
public class UserController {

    IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public List<User> getByEmail(@RequestParam(required = false) String email) {
        if (email == null) {
            return userService.getAll();
        } else {
            List<User> userList = new ArrayList<User>();
            User user = userService.getByEmail(email);
            if (user != null) {
                
                userList.add(user);
            }
            return userList;
        }
    }

    @GetMapping("/get/{id}")
    public User getById(@PathVariable int id) {
        return this.userService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        this.userService.add(user);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user) {
        this.userService.update(user);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody User user) {
        this.userService.delete(user);
    }

}
