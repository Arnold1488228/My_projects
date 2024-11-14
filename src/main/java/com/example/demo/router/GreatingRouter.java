package com.example.demo.router;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.example.demo.handler.GreetingHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class GreatingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello)
                .andRoute(GET("/"), greetingHandler::home)
                .andRoute(GET("/users"), greetingHandler::getClients)
                .andRoute(GET("/books"), greetingHandler::getBooks)
                .andRoute(GET("/transactions"), greetingHandler::getTransactions)
                .andRoute(POST("/books").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::createBook)
                .andRoute(POST("/transactions").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::createTransaction);
    }
}
