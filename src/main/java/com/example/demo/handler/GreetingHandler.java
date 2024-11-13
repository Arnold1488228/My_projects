package com.example.demo.handler;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.example.demo.entity.Greeting;
import com.example.demo.entity.Client;
import com.example.demo.entity.Books;
import com.example.demo.entity.Transaction;

import java.awt.print.Book;

@Component
public class GreetingHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring")));
    }

    public Mono<ServerResponse> home(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Main page!"));
    }

    public Mono<ServerResponse> getClients(ServerRequest request) {

        String start = request
                .queryParam("start")
                .orElse("0");


        Flux<Client> clients = Flux.just(
                        new Client(1L, "Vasya", "Pypkin", 18),
                        new Client(2L, "Iva", "Pypkina", 19),
                        new Client(3L, "Inna", "Pypkina", 20)
                )
                .skip(Long.valueOf(start))
                .take(2);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clients, Client.class);
    }
    public Mono<ServerResponse> getBooks(ServerRequest request) {

        String start = request
                .queryParam("start")
                .orElse("0");


        Flux<Books> books = Flux.just(
                        new Books("title1", "autor1", 2000, 1),
                        new Books("title2", "autor2", 2022, 2),
                        new Books("title3", "autor3", 2000, 3)
                )
                .skip(Long.valueOf(start))
                .take(2);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(books, Books.class);
    }
    public Mono<ServerResponse> getTransaction(ServerRequest request) {

        String start = request
                .queryParam("start")
                .orElse("0");


        Flux<Transaction> transaction = Flux.just(
                        new Transaction(1, "Returning a book", 1455, "20.11.24"),
                        new Transaction(2, "Returning a book", 1000, "21.11.24"),
                        new Transaction(3, "Returning a book", 2000, "21.11.24")
                )
                .skip(Long.valueOf(start))
                .take(2);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(transaction, Transaction.class);
    }


}
