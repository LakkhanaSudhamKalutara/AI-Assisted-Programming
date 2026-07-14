package com.assignment.version_b.exceptions;

/**
 * Custom exception thrown when a Member is not found in the system.
 */
public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String message) {
        super(message);
    }
}
