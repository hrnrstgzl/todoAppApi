/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.Business;

import com.hrnrstgzl.todoAppApi.Entities.User;
import java.util.List;

/**
 *
 * @author Harun
 */
public interface IUserService {
    List<User> getAll();
    
    User getById(int id);
    
    User getByEmail(String email);
    
    void add(User user);

    void update(User user);

    void delete(User user);
}
