package com.example.todolistrest;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Todo {
    @Id
    @Basic(optional = false)
    @Column(name = "name", unique = true, nullable = false)
    public String name;
    public int priority;

    public Todo(){
        priority = 2;
    }

    public Todo(String name){
        this.name = name;
        priority = 2;
    }

    public Todo(String name, int priority){
        this.name = name;
        this.priority = priority;
    }
}
