package com.company.exceptions;

public class ItemAlreadyExistsException extends Exception {
    public ItemAlreadyExistsException() {
        super("Item already exists");
    }
}