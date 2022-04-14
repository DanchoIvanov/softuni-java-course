package book;

import java.util.Iterator;

public class Library implements Iterable <Book>{

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public Book get(int index){
        return books[index];
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private class LibraryIterator implements Iterator<Book>{

        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < books.length;
        }

        @Override
        public Book next() {
           Book book = get(counter);
           counter++;
           return book;
        }
    }
}
