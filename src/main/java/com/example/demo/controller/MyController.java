package com.example.demo.controller;
import com.example.demo.entity.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import com.example.demo.entity.Client;
import com.example.demo.entity.Books;
import com.example.demo.entity.Transaction;



@RestController
public class MyController {
    @GetMapping("/clients")
    public Flux<Client> getClients() {
        Flux<Client> clients = Flux.just(
                        new Client(1L, "Vasya", "Pypkin", 18),
                        new Client(2L, "Iva", "Pypkina", 19),
                        new Client(3L, "Inna", "Pypkina", 20)
                )
                .skip(0)
                .take(2);

        return clients;
    }
    @GetMapping("/books")
    public Flux<Books> getBooks() {
        Flux<Books> books = Flux.just(
                        new Books("title1", "autor1", 2000, 1),
                        new Books("title2", "autor2", 2022, 2),
                        new Books("title3", "autor3", 2000, 3)
                )
                .skip(0)
                .take(2);

        return books;
    }
    @GetMapping("/transactions")
    public Flux<Transaction> getTransactions() {
        Flux<Transaction> transactions = Flux.just(
                        new Transaction(1, "Returning a book", 1455, "20.11.24"),
                        new Transaction(2, "Returning a book", 1000, "21.11.24"),
                        new Transaction(3, "Returning a book", 2000, "21.11.24")
                )
                .skip(0)
                .take(2);

        return transactions;
    }

}
