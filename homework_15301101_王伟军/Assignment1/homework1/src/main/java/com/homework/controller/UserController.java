package com.homework.controller;

import com.homework.model.Person;
import com.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }


    @ResponseBody
    @PostMapping("/login")
    public String doLogin(String email, String password, HttpServletRequest request) {
        return userService.doLogin(email,password,request);
    }



    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    @ResponseBody
    @PostMapping("/register")
    public String doRegister(Person user) {
       return userService.doRegister(user);
    }


    @RequestMapping(value = "/count")
    @ResponseBody
    public Long getCount() {
        return userService.count();
    }
}
