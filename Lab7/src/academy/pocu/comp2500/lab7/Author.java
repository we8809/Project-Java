package academy.pocu.comp2500.lab7;

public class Author {
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return String.format(this.firstName + " " + this.lastName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Author) || this.hashCode() != obj.hashCode()) {
            return false;
        }

        Author author = (Author) obj;
        return this.firstName.equals(author.firstName) && this.lastName.equals(author.lastName);
    }

    public int hashCode() {
        return this.firstName.hashCode() ^ (this.lastName.hashCode() << 16);
    }
}
