package book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        int compared = b1.getTitle().compareTo(b2.getTitle());

        if (compared == 0){
            compared = Integer.compare(b1.getYear(), b2.getYear());
        }
        return compared;
    }
}
