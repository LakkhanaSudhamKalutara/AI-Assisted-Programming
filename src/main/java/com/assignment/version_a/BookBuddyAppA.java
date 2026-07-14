package com.assignment.version_a;

import com.assignment.version_a.models.Book;
import com.assignment.version_a.models.Member;
import com.assignment.version_a.services.LibraryService;

import java.util.Scanner;

public class BookBuddyAppA {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to BookBuddy Library Management System (Traditional Version)");

        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Available Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choiceStr = scanner.nextLine();
            int choice = -1;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter Book ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Book Author: ");
                String author = scanner.nextLine();

                if (id.isEmpty() || title.isEmpty() || author.isEmpty()) {
                    System.out.println("Error: Fields cannot be empty.");
                } else {
                    Book book = new Book(id, title, author);
                    libraryService.addBook(book);
                }
            } else if (choice == 2) {
                System.out.print("Enter Member ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter Member Name: ");
                String name = scanner.nextLine();

                if (id.isEmpty() || name.isEmpty()) {
                    System.out.println("Error: Fields cannot be empty.");
                } else {
                    Member member = new Member(id, name);
                    libraryService.registerMember(member);
                }
            } else if (choice == 3) {
                System.out.print("Enter Member ID: ");
                String memberId = scanner.nextLine();
                System.out.print("Enter Book ID: ");
                String bookId = scanner.nextLine();

                if (memberId.isEmpty() || bookId.isEmpty()) {
                    System.out.println("Error: Fields cannot be empty.");
                } else {
                    libraryService.borrowBook(memberId, bookId);
                }
            } else if (choice == 4) {
                System.out.print("Enter Member ID: ");
                String memberId = scanner.nextLine();
                System.out.print("Enter Book ID: ");
                String bookId = scanner.nextLine();

                if (memberId.isEmpty() || bookId.isEmpty()) {
                    System.out.println("Error: Fields cannot be empty.");
                } else {
                    libraryService.returnBook(memberId, bookId);
                }
            } else if (choice == 5) {
                libraryService.viewAvailableBooks();
            } else if (choice == 6) {
                exit = true;
                System.out.println("Exiting BookBuddy. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        scanner.close();
    }
}
