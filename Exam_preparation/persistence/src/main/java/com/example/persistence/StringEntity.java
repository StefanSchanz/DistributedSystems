package com.example.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StringEntity {     // Definition of a new Entity
    @Id
    private String string;      // string, that's the ID of an entity! - with this ID the objects are referenced

    public StringEntity(){}

    public StringEntity(String string){
        this.string = string;
    }   // Constructor to create a new string Entity

    public String getString(){
        return this.string;
    }       // return current String entity
}
