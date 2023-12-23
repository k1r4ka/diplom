package com.example.service;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException(String message) {
        super(message);
    }
}