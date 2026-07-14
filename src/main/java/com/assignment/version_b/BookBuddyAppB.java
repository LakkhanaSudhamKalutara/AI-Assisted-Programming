package com.assignment.version_b;

import com.assignment.version_b.exceptions.BookNotFoundException;
import com.assignment.version_b.exceptions.MemberNotFoundException;
import com.assignment.version_b.models.Book;
import com.assignment.version_b.models.Member;
import com.assignment.version_b.services.LibraryService;

import java.util.Scanner;

/**
 * Main application entry point for the AI-Assisted version of BookBuddy.
 * Demonstrates robust exception handling and clean UI feedback.
 */
public class BookBuddyAppB {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("==================================================");
        System.out.println(" Welcome to BookBuddy (AI-Assisted Version)       ");
        System.out.println("==================================================");

        while (!exit) {
            displayMenu();
            String choiceStr = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(choiceStr);
                exit = processChoice(choice, scanner, libraryService);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input: Please enter a valid number.");
            } catch (BookNotFoundException | MemberNotFoundException | IllegalArgumentException | IllegalStateException e) {
                System.out.println("❌ Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("💥 An unexpected error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Register Member");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. View Available Books");
        System.out.println("6. Exit");
        System.out.print("👉 Enter your choice: ");
    }

    private static boolean processChoice(int choice, Scanner scanner, LibraryService libraryService) {
        switch (choice) {
            case 1 -> {
                System.out.print("Enter Book ID: ");
                String id = scanner.nextLine().trim();
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine().trim();
                System.out.print("Enter Book Author: ");
                String author = scanner.nextLine().trim();

                validateInput(id, title, author);
                libraryService.addBook(new Book(id, title, author));
            }
            case 2 -> {
                System.out.print("Enter Member ID: ");
                String id = scanner.nextLine().trim();
                System.out.print("Enter Member Name: ");
                String name = scanner.nextLine().trim();

                validateInput(id, name);
                libraryService.registerMember(new Member(id, name));
            }
            case 3 -> {
                System.out.print("Enter Member ID: ");
                String memberId = scanner.nextLine().trim();
                System.out.print("Enter Book ID: ");
                String bookId = scanner.nextLine().trim();

                validateInput(memberId, bookId);
                libraryService.borrowBook(memberId, bookId);
            }
            case 4 -> {
                System.out.print("Enter Member ID: ");
                String memberId = scanner.nextLine().trim();
                System.out.print("Enter Book ID: ");
                String bookId = scanner.nextLine().trim();

                validateInput(memberId, bookId);
                libraryService.returnBook(memberId, bookId);
            }
            case 5 -> libraryService.viewAvailableBooks();
            case 6 -> {
                System.out.println("👋 Exiting BookBuddy. Have a great day!");
                return true;
            }
            default -> System.out.println("⚠️ Invalid choice. Please enter a number between 1 and 6.");
        }
        return false;
    }

    private static void validateInput(String... inputs) {
        for (String input : inputs) {
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Fields cannot be empty.");
            }
        }
    }
}
