package com.usps.usps.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Api Key Not found")
public class CustomeException extends RuntimeException {
}
