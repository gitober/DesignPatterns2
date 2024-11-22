package Prototype;

public class Book {
    private final String author;
    private final String title;
    private final String genre;
    private final int publicationYear;

    // Constructor
    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // Copy constructor
    public Book(Book other) {
        this.author = other.author;
        this.title = other.title;
        this.genre = other.genre;
        this.publicationYear = other.publicationYear;
    }

    @Override
    public String toString() {
        return String.format("%s: '%s' (%s, %d)", author, title, genre, publicationYear);
    }
}
