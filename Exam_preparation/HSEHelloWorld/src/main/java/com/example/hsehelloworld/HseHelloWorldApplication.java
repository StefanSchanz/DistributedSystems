package com.example.hsehelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController     // Need that to Define the Handler for Rest Calls
public class HseHelloWorldApplication {

    private String temp_stored_string = "";

    @GetMapping             // GetMapping on Functions that should Used with GETs!
    public String sayHello(){   // Function that responds to a GET Call on the Webserver!
        if(temp_stored_string.isEmpty()){
            return "Hello Esslingen, Summer Semester 2021";
        }
        else{
            return "Got some Temporary String for you!: " + temp_stored_string;
        }
    }

    @GetMapping("/otherEndpoint")             // GetMapping that answers on Endpoint /otherEndpoint
    public String sayHelloAgain(){   // Function that responds to a GET Call on the Webserver!
        return "Hello Esslingen, Summer Semester 2021 (2)";
    }

    @PostMapping("/post/{stringParam}")
    public String getInput(@PathVariable String stringParam){
        temp_stored_string = stringParam;
        return "I have received: " + stringParam;
    }

    public static void main(String[] args) {
        SpringApplication.run(HseHelloWorldApplication.class, args);
    }

}
