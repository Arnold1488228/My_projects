package com.example.demo.controller;

import com.example.demo.entity.Transaction;
import com.example.demo.entity.Client;
import com.example.demo.entity.Books;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class MyController {

    @GetMapping("/clients")
    public Flux<Client> getClients() {
        return Flux.just(
                new Client(1L, "Vasya", "Pypkin", 18),
                new Client(2L, "Iva", "Pypkina", 19),
                new Client(3L, "Inna", "Pypkina", 20)
        ).take(2);
    }

    @GetMapping("/books")
    public Flux<Books> getBooks() {
        return Flux.just(
                new Books("title1", "author1", 2000, 1),
                new Books("title2", "author2", 2022, 2),
                new Books("title3", "author3", 2000, 3)
        ).take(2);
    }

    @GetMapping("/transactions")
    public Flux<Transaction> getTransactions() {
        return Flux.just(
                new Transaction(1, "Returning a book", 1455, "20.11.24"),
                new Transaction(2, "Returning a book", 1000, "21.11.24"),
                new Transaction(3, "Returning a book", 2000, "21.11.24")
        ).take(2);
    }
}
