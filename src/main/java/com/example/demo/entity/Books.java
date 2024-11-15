package com.example.demo.entity;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Books {
    private String title;
    private String author;
    private int publicationYear;
    private int genre;
}
