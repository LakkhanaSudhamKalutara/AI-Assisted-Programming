package com.assignment.version_b.exceptions;

/**
 * Custom exception thrown when a Book is not found in the inventory.
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
