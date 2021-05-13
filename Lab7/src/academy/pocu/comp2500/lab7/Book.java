package academy.pocu.comp2500.lab7;

public class Book {
    private String title;
    private Author author;
    private int publicationYear;
    private Genre genre;

    public Book(String title, Author author, int publicationYear, Genre genre) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    public String toString() {
        return String.format(this.title + " [" + this.author.toString() + "]");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Book) || this.hashCode() != obj.hashCode()) {
            return false;
        }

        Book book = (Book) obj;
        return this.toString().equals(book.toString()) &&
                this.publicationYear == book.publicationYear &&
                this.genre == book.genre;
    }

    public int hashCode() {
        int hash = 17;

        hash = hash * 31 + this.author.hashCode();
        hash = hash * 31 + this.publicationYear;
        hash = hash * 31 + this.genre.hashCode();

        return hash;
    }
}
