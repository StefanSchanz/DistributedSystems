package com.example.persistence_example;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JPAController {

    @Autowired
    private StringRepository stringRepository;
    private Logger logger = LoggerFactory.getLogger(JPAController.class);

    @GetMapping("/strings")
    public String readAllStrings(){

        List<String> listofStrings = new ArrayList<String>();

        //stringRepository.findAll().forEach(string -> listofStrings.add(string.getString()));
        for(StringEntity string : stringRepository.findAll()) listofStrings.add(string.getString());
        logger.info("Strings being returned: ", listofStrings);

        return listofStrings.toString();
    }

    @PostMapping("/strings/{newString}")
    public String createString(@PathVariable String newString){
        logger.error("Strings to add: {}", newString);

        stringRepository.save(new StringEntity(newString));
        //List<String> listofStrings = new ArrayList<String>();
        //logger.debug("Current list of strings: {}", getAllStrings());
        return newString + " has been added to the list";
    }

    @PutMapping("/strings/{oldString}/{newString}")
    public String updateString(@PathVariable String oldString, @PathVariable String newString){
        /*
        logger.info("Strings to delete: ", oldString);
        // listOfStrings.remove(oldString);
        logger.info("Strings to add: ", newString);
        // listOfStrings.add(newString);
        return newString + " has been added to the list";
        */
        return "nothing happened with " + newString;
    }

    @DeleteMapping("/strings/{stringToDelete}")
    public String deleteString(@PathVariable String stringToDelete){
        logger.info("Strings to delete: ", stringToDelete);
        // listOfStrings.remove(stringToDelete);
        return stringToDelete + " has most likely removed from the list";
    }

}
