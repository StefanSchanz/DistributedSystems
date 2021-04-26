package com.example.persistence_example;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StringEntity {
    @Id
    private String string;

    public String getString() {
        return string;
    }

    public StringEntity(){

    }

    public StringEntity(String string){
        this.string = string;
    }



}
