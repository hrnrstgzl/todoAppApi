/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrnrstgzl.todoAppApi.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Harun
 */
@Entity
@Table(name="todo_item")
public class TodoItem {
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @Column(name="create_date")
    private String createDate;
    
    @Column(name="deadline")
    private String deadline;
    
    @Column(name="status")
    private String status;
    
    @Column(name="dependency_id")
    private int dependencyId;
    
    @Column(name="list_id")
    private int listId;

    public TodoItem() {
    }

    public TodoItem(int id, String name, String description, String createDate, String deadline, String status, int dependencyId, int listId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.deadline = deadline;
        this.status = status;
        this.dependencyId = dependencyId;
        this.listId = listId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    
    
    
}
