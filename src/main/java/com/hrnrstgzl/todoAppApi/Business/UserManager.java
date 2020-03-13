/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.Business;

import com.hrnrstgzl.todoAppApi.DataAccess.IUserDal;
import com.hrnrstgzl.todoAppApi.Entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Harun
 */
@Service
public class UserManager implements IUserService{
    
    IUserDal userDal ;

    @Autowired
    public UserManager(IUserDal userDal) {
        this.userDal = userDal;
    }
    
    
    @Override
    @Transactional
    public List<User> getAll() {
       return this.userDal.getAll();
    }

    @Override
    @Transactional
    public User getById(int id) {
        return this.userDal.getById(id);
    }

    @Override
    @Transactional
    public User getByEmail(String email) {
        return this.userDal.getByEmail(email);
    }

    @Override
    @Transactional
    public void add(User user) {
        this.userDal.add(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        this.userDal.update(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        this.userDal.delete(user);
    }
    
}
