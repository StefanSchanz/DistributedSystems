package com.example.kubernetesexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KubernetesExampleApplication {

    @Value("${hostname}")
    String hostName;

    @GetMapping("/hello")
    public String hello(){
        return hostName + ": Hello!";
    }

    @GetMapping("/crash")
    public String doSomething(){
        // Doo something
        System.exit(1);
        return("testing");
    }

    public static void main(String[] args) {
        SpringApplication.run(KubernetesExampleApplication.class, args);
    }


}
