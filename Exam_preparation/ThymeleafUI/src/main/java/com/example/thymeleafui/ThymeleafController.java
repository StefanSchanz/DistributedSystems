package com.example.thymeleafui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

@Controller
public class ThymeleafController {
    @Value("${welcome.recipient}")
    private String message;

    private ArrayList<String> todoList;

    @GetMapping("/")
    public String displayPage(Model model){
        Todo[] todos = WebClient.create("http://localhost:8080/todos/").get().retrieve().bodyToMono(Todo[].class).block();
        model.addAttribute("message", message);     // First "message" is in the html template - message is variable
        model.addAttribute("todos", todos);         // "todos" is again in the html template
        return "page";
    }

    @GetMapping("/{name}")
    public String displayPage(@PathVariable String name, Model model){
        if(name != null && name.length() != 0){
            message = name;
        }
        model.addAttribute("message", message);
        model.addAttribute("list", todoList);

        return "page";
    }

    @PostMapping("/")
    public String addItem(@RequestParam String newItem, Model model){
        System.out.println("New item: " + newItem);

        WebClient.create("http://localhost:8080/todos/"+newItem).post().retrieve().bodyToMono(Todo.class).block();
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam String oldItem, Model model){
        System.out.println("Old item to delete: " + oldItem);

        WebClient.create("http://localhost:8080/todos/"+oldItem).delete().retrieve().bodyToMono(Void.class).block();
        return "redirect:/";
    }
}
