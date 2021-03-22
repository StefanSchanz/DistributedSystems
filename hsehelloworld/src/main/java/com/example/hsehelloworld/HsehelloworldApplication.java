package com.example.hsehelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HsehelloworldApplication {

    private String state = "no_state";

    @GetMapping
    public String sayHello(){
        return "Hello Neuffen, Summer Semester 2021 (" +  state + ")";
    }

    @GetMapping("/otherEndpoint")
    public String sayHelloAgain(){
        return "Hello Neuffen, Summer Semester 2021 (from other endpoint)";
    }

    @PostMapping("/postSomething/{stringParameter}")
    public String saySomethingWithInput(@PathVariable String stringParameter){
        state = stringParameter;
        return "I have received the beautiful String: " + stringParameter;
    }

    public static void main(String[] args) {
        SpringApplication.run(HsehelloworldApplication.class, args);
    }

}
