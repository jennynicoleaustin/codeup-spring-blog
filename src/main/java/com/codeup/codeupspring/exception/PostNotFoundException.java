package com.codeup.codeupspring.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long id) {
        super("The post id " + id + " does not exist in our records");
    }
}
