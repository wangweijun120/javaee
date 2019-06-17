package com.homework.controller;

import com.homework.model.Person;
import com.homework.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Api(tags="用户API")
@Controller
@RequestMapping("/api/v2")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }


    @ResponseBody
    @ApiOperation(value="用户登录")
    @PostMapping("/login")
    public String doLogin(String email, String password, HttpServletRequest request) {
        return userService.doLogin(email,password,request);
    }


    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    @ResponseBody
    @ApiOperation(value="用户注册)")
    @PutMapping("/register")
    public String doRegister(Person user) {
       return userService.doRegister(user);
    }

    @ApiOperation(value="统计用户数量")
    @RequestMapping(value = "/count")
    public long getCount() {
        return userService.count();
    }
}
