package com.example.crudcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@SpringBootApplication
public class CrudcontrollerApplication {

    ArrayList<String> listOfStrings = new ArrayList<String>();

    @GetMapping("/strings")
    public String getAllStrings(){
        return listOfStrings.toString();
    }

    @PostMapping("/strings/{newString}")
    public String addNewString(@PathVariable String newString){
        listOfStrings.add(newString);
        return newString + " has been added to the list";
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudcontrollerApplication.class, args);
    }

}
