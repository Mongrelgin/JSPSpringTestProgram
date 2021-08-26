package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ApplicationController {
    @Autowired
    private UserService service;

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "welcomepage";
    }

    @RequestMapping("/register")
    public String registration(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_REGISTER");
        return "welcomepage";
    }

    @PostMapping("/save-user")
    public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
        service.saveMyUser(user);
        request.setAttribute("users", service.showAllUsers());
        request.setAttribute("mode","ALL_USERS");
        return "welcomepage";
    }

    @GetMapping("/show-users")
    public String showAllUsers(HttpServletRequest request) {
        request.setAttribute("users", service.showAllUsers());
        request.setAttribute("mode","ALL_USERS");
        return "welcomepage";
    }

    @RequestMapping("/delete-user")
    public String deleteUser(@RequestParam Integer id, HttpServletRequest request) {
        service.deleteMyUser(id);
        request.setAttribute("users", service.showAllUsers());
        request.setAttribute("mode","ALL_USERS");
        return "welcomepage";
    }

    @RequestMapping("/edit-user")
    public String editUser(@RequestParam Integer id, HttpServletRequest request) {
        request.setAttribute("user", service.editUser(id));
        request.setAttribute("mode","MODE_UPDATE");
        return "welcomepage";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_LOGIN");
        return "welcomepage";
    }

    @RequestMapping ("/login-user")
    public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
        if(service.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
            return "homepage";
        }
        else {
            request.setAttribute("error", "Invalid Username or Password");
            request.setAttribute("mode", "MODE_LOGIN");
            return "welcomepage";

        }
    }
}
