package com.example.crudcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class CrudControllerApplication {
    ArrayList<String> stringList = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(CrudControllerApplication.class);

    @GetMapping("/strings")
    public String readAllStrings(){
        logger.info("Strings being returned {}", stringList);
        return stringList.toString();
    }

    @PostMapping("/strings/{newString}")
    public String createString(@PathVariable String newString){
        logger.error("String to add: {}", newString);
        stringList.add(newString);
        logger.debug("Current list of Strings{}", stringList);
        return newString + " has been added to the list";
    }

    @PutMapping("/strings/{oldString}/{newString}")
    public String updateString(@PathVariable String oldString, @PathVariable String newString){
        for (int i = 0; i < stringList.size(); i++){
            if(oldString.equals(stringList.get(i))){
                String tmp = stringList.get(i);
                stringList.set(i, newString);
                return "sucessfully changed " + tmp + " to " + newString;
            }
        }
        return "String " + oldString + " was not found!";
    }

    @DeleteMapping("/strings/{stringToDelete}")
    public String deleteString(@PathVariable String stringToDelete){
        logger.info("String to delete: {}", stringToDelete);
        stringList.remove(stringToDelete);
        logger.debug("Current list of strings {}", stringList);
        return stringToDelete + " has been removed from the internal list!";
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudControllerApplication.class, args);
    }

}
