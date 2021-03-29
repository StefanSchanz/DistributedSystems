package com.example.crudcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class CrudcontrollerApplication {

    ArrayList<String> listOfStrings = new ArrayList<String>();
    private Logger logger = LoggerFactory.getLogger(CrudcontrollerApplication.class);

    @GetMapping("/strings")
    public String getAllStrings(){
        logger.info("Strings being returned: ", listOfStrings.toString());
        return listOfStrings.toString();
    }

    @PostMapping("/strings/{newString}")
    public String addNewString(@PathVariable String newString){
        logger.error("Strings to add: {}", newString);
        listOfStrings.add(newString);
        logger.debug("Current list of strings: {}", listOfStrings.toString());
        return newString + " has been added to the list";
    }

    @PutMapping("/strings/{oldString}/{newString}")
    public String updateString(@PathVariable String oldString, @PathVariable String newString){
        logger.info("Strings to delete: ", oldString);
        listOfStrings.remove(oldString);
        logger.info("Strings to add: ", newString);
        listOfStrings.add(newString);
        return newString + " has been added to the list";
    }

    @DeleteMapping("/strings/{stringToDelete}")
    public String deleteString(@PathVariable String stringToDelete){
        logger.info("Strings to delete: ", stringToDelete);
        listOfStrings.remove(stringToDelete);
        return stringToDelete + " has most likely removed from the list";
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudcontrollerApplication.class, args);
    }

}
