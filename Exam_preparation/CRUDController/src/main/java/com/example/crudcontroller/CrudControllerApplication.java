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

    // Declaration of the stringList to be used
    ArrayList<String> stringList = new ArrayList<>();

    // Declaration of a Logger. That's just seems to be a output to the Server Console in some special way.
    // Different levels of logging are available.
    private Logger logger = LoggerFactory.getLogger(CrudControllerApplication.class);

    // Get Mapping for URL /strings
    @GetMapping("/strings")
    public String readAllStrings(){
        logger.info("Strings being returned {}", stringList);
        return stringList.toString();
    }

    // Post Mapping for...
    @PostMapping("/strings/{newString}")
    public String createString(@PathVariable String newString){
        logger.error("String to add: {}", newString);
        stringList.add(newString);
        logger.debug("Current list of Strings{}", stringList);
        return newString + " has been added to the list";
    }

    // Put Mapping...
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

    // Delete Mapping
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
