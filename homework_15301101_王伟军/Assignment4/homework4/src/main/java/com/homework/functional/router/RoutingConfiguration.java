package com.homework.functional.router;

import com.homework.functional.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author wangweijun
 */
@Configuration
public class RoutingConfiguration {

   private static final String API_VER ="/api/v3/";

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler){
        return route(POST(API_VER+"login").and(accept(MediaType.APPLICATION_JSON)),userHandler::doLogin)
                .andRoute(POST(API_VER+"register").and(accept(MediaType.APPLICATION_JSON)),userHandler::doRegister)
                .andRoute(GET(API_VER+"count"),userHandler::countUser);
    }

}

