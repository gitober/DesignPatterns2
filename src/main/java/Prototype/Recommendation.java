package Prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation {
    private String targetAudience;
    private final List<Book> books;

    // Constructor
    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    // Copy constructor for deep copy
    public Recommendation(Recommendation other) {
        this.targetAudience = other.targetAudience;
        this.books = new ArrayList<>();
        for (Book book : other.books) {
            this.books.add(new Book(book));
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recommendation for '").append(targetAudience).append("':\n");
        for (Book book : books) {
            sb.append("  - ").append(book.toString()).append("\n");
        }
        return sb.toString();
    }
}
