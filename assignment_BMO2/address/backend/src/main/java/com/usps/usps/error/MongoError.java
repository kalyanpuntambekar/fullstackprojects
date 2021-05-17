package com.usps.usps.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class MongoError {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    

    private String message;

    private MongoError() {
        timestamp = LocalDateTime.now();
    }

    public MongoError(HttpStatus status) {
        this();
        this.status = status;
    }

    
    
}
