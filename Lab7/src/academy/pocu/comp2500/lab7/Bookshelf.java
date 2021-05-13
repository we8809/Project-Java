package academy.pocu.comp2500.lab7;

import java.util.HashSet;
import java.util.Iterator;

public class Bookshelf {
    private int maxBookCount;
    private HashSet<Book> books;

    public Bookshelf(int maxBookCount) {
        this.maxBookCount = maxBookCount;
        this.books = new HashSet<Book>();
    }

    public boolean add(Book book) {
        if (this.books.size() == maxBookCount) {
            return false;
        }

        return this.books.add(book);
    }

    public boolean remove(Book book) {
        if (this.books.size() == 0) {
            return false;
        }

        return this.books.remove(book);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        return false;
    }
}
