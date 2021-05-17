package com.usps.usps.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomException extends RuntimeException {
    private String message;

    public CustomException(String message, HttpStatus httpStatus){
        super(message);
        this.message=message;
        this.httpStatus=httpStatus;
    }
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    private HttpStatus httpStatus;
}
