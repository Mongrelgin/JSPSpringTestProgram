package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String hello() {
        return "This is home page";
    }

    @GetMapping("/saveuser")
    public String saveUser(
            @RequestParam String username,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam Integer age,
            @RequestParam String password
    ) {
        User user = new User(username, firstname, lastname, age, password);
        service.saveMyUser(user);
        return "User saved";
    }
}
