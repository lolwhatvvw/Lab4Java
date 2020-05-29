package com.company.exceptions;

public class NegativeQuantityException extends Exception {
    public NegativeQuantityException() {
        super("Negative quantity");
    }
}