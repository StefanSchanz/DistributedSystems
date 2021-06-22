package com.example.todolistrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("todos")
public class TodoRestController {
    @Autowired
    TodoRestRepository todoRestRepository;

    @GetMapping(produces = "application/json")
    List<Todo> all(){
        List<Todo> todos = new ArrayList<>();
        todoRestRepository.findAll().forEach(todos::add);
        return todos;
    }

    @GetMapping(path = "/{name}", produces = "application/json")
    Todo getTodo(@PathVariable String name){
        Optional<Todo> optional = todoRestRepository.findById(name);
        Todo todo = optional.get();
        return todo;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    Todo addTodo(@RequestBody Todo todo){
        todoRestRepository.save(todo);
        return todo;
    }

    @PostMapping(path="/{name}", produces = "application/json")
    Todo addTodo(@PathVariable String name){
        Todo todo = new Todo(name);
        todoRestRepository.save(todo);
        return todo;
    }

    @PostMapping(path="/{name}/{priority}", produces = "application/json")
    Todo addTodo(@PathVariable String name, @PathVariable int priority){
        Todo todo = new Todo(name, priority);
        todoRestRepository.save(todo);
        return todo;
    }

    @DeleteMapping(path = "/{name}", produces = "application/json")
    Todo deleteTodo(@PathVariable String name){
        todoRestRepository.deleteById(name);
        return null;
    }



}
