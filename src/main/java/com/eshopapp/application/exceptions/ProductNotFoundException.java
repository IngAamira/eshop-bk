package com.eshopapp.application.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Integer productId) {
        super("Product not found with ID: " + productId);
    }

}
