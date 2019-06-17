package com.homework.service;

import com.homework.model.Person;

import javax.servlet.http.HttpServletRequest;


public interface UserService {

    String doLogin(String email, String password, HttpServletRequest request);

    String doRegister(Person user);

    long count();
}
