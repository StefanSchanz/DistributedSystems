package com.example.hsehelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController     // Need that to Define the Handler for Rest Calls
public class HseHelloWorldApplication {

    @GetMapping             // GetMapping on Functions that should Used with GETs!
    public String sayHello(){   // Function that responds to a GET Call on the Webserver!
        return "Hello Esslingen, Summer Semester 2021";
    }

    @GetMapping("/otherEndpoint")             // GetMapping that answers on Endpoint /otherEndpoint
    public String sayHelloAgain(){   // Function that responds to a GET Call on the Webserver!
        return "Hello Esslingen, Summer Semester 2021 (2)";
    }

    public static void main(String[] args) {
        SpringApplication.run(HseHelloWorldApplication.class, args);
    }

}
