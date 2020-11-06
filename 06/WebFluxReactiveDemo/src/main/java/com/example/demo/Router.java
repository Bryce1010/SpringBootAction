package com.example.demo;

import com.example.demo.controller.HelloWorldHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class Router {

    @Autowired
    private HelloWorldHandler helloWorldHandler;

    @Bean
    public RouterFunction<ServerResponse>getString(){
        return route(GET("/helloworld"),req->helloWorldHandler.sayHelloWorld(req));
    }
}
