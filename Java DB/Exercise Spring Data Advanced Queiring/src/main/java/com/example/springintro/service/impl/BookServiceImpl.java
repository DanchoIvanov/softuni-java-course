package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> findByAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository
                .findByAgeRestriction(ageRestriction)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());

    }

    @Override
    public Set<String> findByEditionTypeAndCopiesLessThan(EditionType gold, int copies) {
        return bookRepository
                .findByEditionTypeAndCopiesLessThan(gold, copies)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
    }


    @Override
    public Set<Book> findByPriceLessThanOrPriceGreaterThan(float lowerBound, float upperBound) {
        BigDecimal lower = BigDecimal.valueOf(lowerBound);
        BigDecimal upper = BigDecimal.valueOf(upperBound);

        return new HashSet<>(bookRepository
                .findByPriceLessThanOrPriceGreaterThan(lower, upper));

    }

    @Override
    public Set<String> findByReleaseDateNot(int year) {
        LocalDate yearBeginning = LocalDate.of(year, 1, 1);
        LocalDate yearEnding = LocalDate.of(year, 12, 31);

        return bookRepository
                .findByReleaseDateBeforeOrReleaseDateAfter(yearBeginning, yearEnding)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Book> findByReleaseDateBefore(String date) {
        LocalDate searchDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        return new HashSet<>(bookRepository
                .findAllByReleaseDateBefore(searchDate));
    }

    @Override
    public Set<String> findByTitleContainingIgnoreCase(String input) {
        return bookRepository
                .findByTitleContainingIgnoreCase(input)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());

    }

    @Override
    public long getBookCountByTitleLength(long length) {
        return bookRepository
                .getBookCountByTitleLength(length);
    }

    @Override
    public BookSummary getInformationForTitle(String title) {
        return this.bookRepository.findSummaryForTitle(title);
    }


    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
