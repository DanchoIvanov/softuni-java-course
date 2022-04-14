package com.example.springintro.service;

import com.example.springintro.model.entity.Author;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    Set<Author> findByFirstNameEndingWith(String input);

    Set<Author> findByLastNameStartingWith(String input);

    List<Author> findAllByBooksSizeDESC();
}
