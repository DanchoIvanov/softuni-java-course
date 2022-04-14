package book;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.setAuthors(authors);

    }
    private void setAuthors(String... authors){
        this.authors = Arrays.stream(authors).collect(Collectors.toList());
    }

    @Override
    public int compareTo(Book other) {
        int compared = this.getTitle().compareTo(other.getTitle());

        if (compared == 0){
            compared = Integer.compare(this.getYear(), other.getYear());
        }

        return compared;
    }
}
