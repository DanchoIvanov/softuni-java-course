package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

//        seedData();
//
//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
//
//        01
//        String ageRestriction = scanner.nextLine();
//        bookTitlesByAgeRestriction(ageRestriction);
//
//        02
//        goldenEditionBookTitlesWithLessThan5000Copies();
//
//        03
//        booksByPrice();
//
//        04
//        int year = Integer.parseInt(scanner.nextLine());
//        printAllBooksNotReleasedInYear(year);
//
//        05
//        String date = scanner.nextLine();
//        printAllBooksReleasedBeforeDate(date);
//
//        06
//        String input = scanner.nextLine();
//        authorsSearch(input);
//
//        07
//        String input = scanner.nextLine();
//        booksSearch(input);
//
//        08
//        String input = scanner.nextLine();
//        bookTitlesSearch(input);
//
//        09
//        long size = Long.parseLong(scanner.nextLine());
//        countBooks(size);
//
//        10
//        totalBookCopies();
//
//        11
        String title = scanner.nextLine();
        reducedBook(title);

    }

    private void reducedBook(String title) {
        BookSummary summary = this.bookService.getInformationForTitle(title);
        System.out.println(summary);
    }

    private void totalBookCopies() {
        authorService.findAllByBooksSizeDESC()
                .forEach(a -> {
                    int totalCount = a.getBooks()
                            .stream()
                            .mapToInt(Book::getCopies)
                            .sum();
                    System.out.printf("%s %s - %d%n",a.getFirstName(), a.getLastName(), totalCount);
                });
    }


    private void countBooks(long length) {
        long count = bookService.getBookCountByTitleLength(length);
        System.out.printf("There are %d books with longer title than %d symbols%n", count, length);
    }

    private void bookTitlesSearch(String input) {
        authorService
                .findByLastNameStartingWith(input)
                .forEach(a -> {
                    a.getBooks()
                            .forEach(b -> System.out.printf("%s (%s %s)%n", b.getTitle(), a.getFirstName(), a.getLastName()));
                });
    }

    private void booksSearch(String input) {
        bookService
                .findByTitleContainingIgnoreCase(input)
                .forEach(System.out::println);
    }

    private void authorsSearch(String input) {
        authorService
                .findByFirstNameEndingWith(input)
                .forEach(a -> System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));
    }

    private void printAllBooksReleasedBeforeDate(String date) {
        bookService
                .findByReleaseDateBefore(date)
                .forEach(b -> System.out.printf("%s %s %.2f%n",b.getTitle(), b.getEditionType(), b.getPrice()));
    }

    private void printAllBooksNotReleasedInYear(int year) {
        bookService
                .findByReleaseDateNot(year)
                .forEach(System.out::println);
    }

    private void booksByPrice() {
        bookService
                .findByPriceLessThanOrPriceGreaterThan(5, 40)
                .forEach(b -> System.out.printf("%s - %.2f%n", b.getTitle(), b.getPrice()));
    }

    private void goldenEditionBookTitlesWithLessThan5000Copies() {
        bookService
                .findByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .forEach(System.out::println);
    }

    private void bookTitlesByAgeRestriction(String ageRestriction) {
        bookService
                .findByAgeRestriction(AgeRestriction.valueOf(ageRestriction.toUpperCase()))
                .forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
