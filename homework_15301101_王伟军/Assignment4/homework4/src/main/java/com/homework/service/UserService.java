package com.homework.service;

import com.homework.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author wangweijun
 */
public interface UserService {

    Flux<String> doLogin(String email, String password);

    Flux<String> doRegister(Person user);

    Mono<Long> count();
}
