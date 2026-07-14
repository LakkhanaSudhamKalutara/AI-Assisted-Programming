package com.assignment.version_a.services;

import com.assignment.version_a.models.Book;
import com.assignment.version_a.models.Member;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> inventory;
    private List<Member> members;

    public LibraryService() {
        this.inventory = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.inventory.add(book);
        System.out.println("Book added successfully.");
    }

    public void registerMember(Member member) {
        this.members.add(member);
        System.out.println("Member registered successfully.");
    }

    public void borrowBook(String memberId, String bookId) {
        Member member = null;
        // Manual search for member
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberId().equals(memberId)) {
                member = members.get(i);
                break;
            }
        }

        if (member == null) {
            System.out.println("Error: Member not found.");
            return;
        }

        Book book = null;
        // Manual search for book
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId().equals(bookId)) {
                book = inventory.get(i);
                break;
            }
        }

        if (book == null) {
            System.out.println("Error: Book not found.");
            return;
        }

        if (book.isAvailable()) {
            book.setAvailable(false);
            member.borrowBook(book);
            System.out.println("Success: Book '" + book.getTitle() + "' borrowed by " + member.getName());
        } else {
            System.out.println("Error: Book is currently unavailable.");
        }
    }

    public void returnBook(String memberId, String bookId) {
        Member member = null;
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberId().equals(memberId)) {
                member = members.get(i);
                break;
            }
        }

        if (member == null) {
            System.out.println("Error: Member not found.");
            return;
        }

        Book bookToReturn = null;
        for (int i = 0; i < member.getBorrowedBooks().size(); i++) {
            if (member.getBorrowedBooks().get(i).getId().equals(bookId)) {
                bookToReturn = member.getBorrowedBooks().get(i);
                break;
            }
        }

        if (bookToReturn != null) {
            bookToReturn.setAvailable(true);
            member.returnBook(bookToReturn);
            System.out.println("Success: Book returned.");
        } else {
            System.out.println("Error: This book was not borrowed by the member.");
        }
    }

    public void viewAvailableBooks() {
        System.out.println("--- Available Books ---");
        boolean found = false;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).isAvailable()) {
                System.out.println(inventory.get(i).toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books available at the moment.");
        }
    }
}
