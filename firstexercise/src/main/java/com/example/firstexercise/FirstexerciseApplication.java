package com.example.firstexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
@RestController
public class FirstexerciseApplication {

    private List<String> list = new ArrayList<>();

    @GetMapping("/")
    public String getSomething(){
        return("getSomethingBack");
    }

    @GetMapping("/somethingOther")
    public String getSomethingOtherBack(){
        return("getSomethingOtherBack");
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return("Hello World!");
    }

    @GetMapping("/showList")
    public String showList(){
        return(list.toString());
    }

    @PostMapping("/postSomething/{input_param}")
    public String postSomething(@PathVariable String input_param){
        String ret_string = "You posted " + input_param;
        return(ret_string);
    }

    @PostMapping("/postSomething/add/{param}")
    public String add_to_list(@PathVariable String param){
        list.add(param);
        return("Parameter: " + param + " successfully added to the List!");
    }

    @PostMapping("/postSomething/remove/{index}")
    public String remove_index_from_list(@PathVariable int index){
        String tmp = list.get(index);
        list.remove(index);
        return("Parameter: " + tmp + " successfully removed from the List!");
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstexerciseApplication.class, args);
    }

}
