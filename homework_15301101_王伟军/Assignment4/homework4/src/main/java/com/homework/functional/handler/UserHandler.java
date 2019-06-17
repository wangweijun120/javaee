package com.homework.functional.handler;

import com.homework.model.Person;
import com.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author wangweijun
 */
@Component
public class UserHandler {
    private UserService userService;

    @Autowired
    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> doLogin(ServerRequest serverRequest){
        Person person =serverRequest.bodyToFlux(Person.class).blockFirst();
        Flux<String> result = userService.doLogin(person.getEmail(),person.getPassword());
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result,String.class);
    }

    public Mono<ServerResponse> doRegister(ServerRequest serverRequest){
        Person person =serverRequest.bodyToFlux(Person.class).blockFirst();
        Flux<String> result  = userService.doRegister(person);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result,String.class);
    }

    public Mono<ServerResponse> countUser(ServerRequest serverRequest){
        Mono<Long> result= userService.count();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result,Long.class);
    }
}
