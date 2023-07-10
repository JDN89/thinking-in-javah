package org.example.review;

public class CheckedException {
    public static void main(String[] args) {
        try {
            processGreeting(null);
        } catch (HighLevelException e) {
            System.out.println(e.getMessage());

            // Print the stack trace of the original exception
            System.out.println("Original exception:");
            e.getCause().printStackTrace();
        }
    }

    public static void processGreeting(String name) throws HighLevelException {
        try {
            greet(name);
        } catch (InvalidNameException e) {
            throw new HighLevelException("High level description of the problem", e);
        }
    }

    public static void greet(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Name cannot be null or empty");
        }
        System.out.println("Hello, " + name);
    }
}

class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

class HighLevelException extends Exception {
    public HighLevelException(String message, Throwable cause) {
        super(message, cause);
    }
}