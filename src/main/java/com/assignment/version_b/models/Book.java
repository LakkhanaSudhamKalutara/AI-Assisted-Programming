package com.assignment.version_b.models;

import java.util.Objects;

/**
 * Represents a Book in the library.
 * This class uses standard encapsulation with clean JavaDocs,
 * mimicking a well-structured domain entity.
 */
public class Book {
    private final String id;
    private final String title;
    private final String author;
    private boolean isAvailable;

    public Book(String id, String title, String author) {
        this.id = Objects.requireNonNull(id, "Book ID cannot be null");
        this.title = Objects.requireNonNull(title, "Book Title cannot be null");
        this.author = Objects.requireNonNull(author, "Book Author cannot be null");
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("Book [ID=%s, Title='%s', Author='%s', Available=%b]", id, title, author, isAvailable);
    }
}
