package academy.pocu.comp2500.lab7;

import java.util.ArrayList;

public class ReadingList {
    private String name;
    private ArrayList<Book> books;

    public ReadingList(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public boolean remove(Book book) {
        int removeIndex = 0;

        if (!this.books.contains(book)) {
            return false;
        }

        for (Book b : this.books) {
            if (b.equals(book)) {
                break;
            }

            ++removeIndex;
        }

        this.books.remove(removeIndex);
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < this.books.size(); i++) {
            stringBuilder.append(String.format("%d. %s%s", i + 1, this.books.get(i).toString(), System.lineSeparator()));
        }

        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        boolean isEqual = true;

        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof ReadingList) || this.hashCode() != obj.hashCode()) {
            return false;
        }

        ReadingList readingList = (ReadingList) obj;
        for (int i = 0; i < this.books.size(); i++) {
            if (!this.books.get(i).equals(readingList.books.get(i))) {
                isEqual = false;
                break;
            }
        }

        return this.name.equals(readingList.name) && isEqual;
    }

    public int hashCode() {
        int hash = 17;

        hash = 31 * hash + this.name.hashCode();
        for (int i = 0; i < this.books.size(); i++) {
            hash = hash ^ (this.books.get(i).hashCode() * (i + 1));
        }

        return hash;
    }
}
