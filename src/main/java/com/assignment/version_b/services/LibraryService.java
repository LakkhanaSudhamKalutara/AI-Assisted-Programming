package com.assignment.version_b.services;

import com.assignment.version_b.exceptions.BookNotFoundException;
import com.assignment.version_b.exceptions.MemberNotFoundException;
import com.assignment.version_b.models.Book;
import com.assignment.version_b.models.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class handling core business logic for the library.
 * This version uses modern Java features such as Streams and Optionals.
 */
public class LibraryService {
    private final List<Book> inventory = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        inventory.add(book);
        System.out.println("Book added successfully.");
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered successfully.");
    }

    private Member findMemberById(String memberId) {
        return members.stream()
                .filter(m -> m.getMemberId().equals(memberId))
                .findFirst()
                .orElseThrow(() -> new MemberNotFoundException("Member with ID '" + memberId + "' not found."));
    }

    private Book findBookById(String bookId) {
        return inventory.stream()
                .filter(b -> b.getId().equals(bookId))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book with ID '" + bookId + "' not found."));
    }

    public void borrowBook(String memberId, String bookId) {
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        if (!book.isAvailable()) {
            throw new IllegalStateException("Book '" + book.getTitle() + "' is currently unavailable.");
        }

        book.setAvailable(false);
        member.borrowBook(book);
        System.out.println("Success: Book '" + book.getTitle() + "' borrowed by " + member.getName());
    }

    public void returnBook(String memberId, String bookId) {
        Member member = findMemberById(memberId);
        
        Book bookToReturn = member.getBorrowedBooks().stream()
                .filter(b -> b.getId().equals(bookId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("This book was not borrowed by the member."));

        bookToReturn.setAvailable(true);
        member.returnBook(bookToReturn);
        System.out.println("Success: Book '" + bookToReturn.getTitle() + "' returned.");
    }

    public void viewAvailableBooks() {
        System.out.println("--- Available Books ---");
        List<Book> availableBooks = inventory.stream()
                .filter(Book::isAvailable)
                .toList(); // Java 16+ feature

        if (availableBooks.isEmpty()) {
            System.out.println("No books available at the moment.");
        } else {
            availableBooks.forEach(System.out::println);
        }
    }
}
