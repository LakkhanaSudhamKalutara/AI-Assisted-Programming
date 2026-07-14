package com.assignment.version_b.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a library Member.
 * Optimized with defensive copying for collections and proper validation.
 */
public class Member {
    private final String memberId;
    private final String name;
    private final List<Book> borrowedBooks;

    public Member(String memberId, String name) {
        this.memberId = Objects.requireNonNull(memberId, "Member ID cannot be null");
        this.name = Objects.requireNonNull(name, "Member Name cannot be null");
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns an unmodifiable view of the borrowed books list to ensure immutability.
     */
    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    public void borrowBook(Book book) {
        Objects.requireNonNull(book, "Book cannot be null");
        this.borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        Objects.requireNonNull(book, "Book cannot be null");
        this.borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return String.format("Member [ID=%s, Name='%s', Borrowed Books=%d]", memberId, name, borrowedBooks.size());
    }
}
