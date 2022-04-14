package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    Set<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    Set<Book> findByEditionTypeAndCopiesLessThan(EditionType gold, int copies);

    Set<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBound, BigDecimal upperBound);

    Set<Book> findByReleaseDateBeforeOrReleaseDateAfter(LocalDate yearBeginning, LocalDate yearEnding);

    Set<Book> findByTitleContainingIgnoreCase(String input);

    @Query("SELECT count(b) FROM Book b WHERE char_length(b.title) > :length")
    long getBookCountByTitleLength(long length);


    @Query("SELECT b.title AS title," +
            " b.editionType AS editionType," +
            " b.ageRestriction AS ageRestriction," +
            " b.price AS price" +
            " FROM Book b" +
            " WHERE b.title = :title")
    BookSummary findSummaryForTitle(String title);
}
