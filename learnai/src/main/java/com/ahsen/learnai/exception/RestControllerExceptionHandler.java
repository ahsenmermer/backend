package com.ahsen.learnai.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleConflict(Exception exception, WebRequest request){
        String bodyOfResponse = exception.getMessage();
        return handleExceptionInternal(exception, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
