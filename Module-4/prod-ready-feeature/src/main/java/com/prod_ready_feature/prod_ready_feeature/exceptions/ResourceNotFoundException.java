package com.prod_ready_feature.prod_ready_feeature.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
