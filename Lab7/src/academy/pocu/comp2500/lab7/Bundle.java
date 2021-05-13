package academy.pocu.comp2500.lab7;

import java.util.HashSet;
import java.util.Iterator;

public class Bundle {
    private final int BUNDLE_BOOK_MAX_COUNT = 4;

    private String name;
    private HashSet<Book> books;

    public Bundle(String name) {
        this.name = name;
        this.books = new HashSet<Book>();
    }

    public boolean add(Book book) {
        if (this.books.size() == BUNDLE_BOOK_MAX_COUNT) {
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
        boolean isEqual = true;
        Iterator<Book> it;

        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Bundle) || this.hashCode() != obj.hashCode()) {
            return false;
        }

        Bundle bundle = (Bundle) obj;
        if (this.books.size() != bundle.books.size()) {
            return false;
        }

        it = bundle.books.iterator();
        while (it.hasNext()) {
            if (!this.books.contains(it.next())) {
                isEqual = false;
                break;
            }
        }

        return this.name.equals(bundle.name) && isEqual;
    }

    public int hashCode() {
        int hash = 17;
        Iterator<Book> it = this.books.iterator();

        hash = 31 * hash + this.name.hashCode();
        while (it.hasNext()) {
            hash = 31 * hash + it.next().hashCode();
        }

        return hash;
    }
}
