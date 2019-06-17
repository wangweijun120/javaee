package com.homework.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.homework.model.Mail;
import com.homework.model.Person;
import com.homework.service.UserService;
import com.homework.util.JsonResult;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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

    @GetMapping("/info")
    public String info() {
        return "user/info";
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
    public long getCount() {
        return userService.count();
    }


    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendMail(HttpServletRequest request, String className){
        return userService.sendMail(request,className);
    }
}
