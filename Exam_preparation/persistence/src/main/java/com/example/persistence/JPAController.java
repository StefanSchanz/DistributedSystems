package com.example.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JPAController {

    @Autowired
    private StringRepository stringRepository; // For communicating with the Database
    private Logger logger = LoggerFactory.getLogger(JPAController.class); // Logger

    // Get Mapping for URL /strings
    @GetMapping("/strings")
    public String readAllStrings(){
        List<String> listofStrings = new ArrayList<>(); // Creation of ArrayList

        for(StringEntity string: stringRepository.findAll()) { // Communication with the Database
            listofStrings.add(string.getString());
        }

        logger.info("Strings being returned {}", listofStrings);
        return listofStrings.toString();
    }

    // Post Mapping for...
    @PostMapping("/strings/{newString}")
    public String createString(@PathVariable String newString){
        logger.error("String to add: {}", newString);

        stringRepository.save(new StringEntity(newString));     // Save a new StringEntity to the stringRepository!

        logger.debug("Current list of Strings{}", readAllStrings());
        return newString + " has been added to the list";
    }

    // Put Mapping...
    /*
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
    */
}
