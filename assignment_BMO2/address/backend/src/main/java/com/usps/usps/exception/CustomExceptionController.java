package com.usps.usps.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.usps.usps.error.MongoError;

@ControllerAdvice
public class CustomExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> exception(CustomException exception) {
    	MongoError mongoError = new MongoError(HttpStatus.BAD_REQUEST);
        mongoError.setMessage(exception.getMessage());
        return new ResponseEntity<>(mongoError,exception.getHttpStatus());    }
}
