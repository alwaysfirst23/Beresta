package org.example;

public class IncorrectTask extends RuntimeException {
    public IncorrectTask(String message) {
        super(message);
    }
}
