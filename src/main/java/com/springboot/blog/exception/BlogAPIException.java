package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;

// we throw this exception whenever we write some businees logic or validate request parameters
public class BlogAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public BlogAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
