package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    Set<String> findByAgeRestriction(AgeRestriction ageRestriction);

    Set<String> findByEditionTypeAndCopiesLessThan(EditionType gold, int copies);

    Set<Book> findByPriceLessThanOrPriceGreaterThan(float lowerBound, float upperBound);

    Set<String> findByReleaseDateNot(int year);

    Set<Book> findByReleaseDateBefore(String date);

    Set<String> findByTitleContainingIgnoreCase(String input);

    long getBookCountByTitleLength(long length);

    BookSummary getInformationForTitle(String title);
}
