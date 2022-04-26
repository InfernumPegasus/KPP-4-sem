package com.example.service.advice;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class DefaultAdvice extends ResponseEntityExceptionHandler {

    /*BAD_REQUEST status Exceptions handler*/

    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<Object> handleException(@NotNull NumberFormatException e) {
        logger.error("NumberFormatException: " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleException(@NotNull MethodArgumentTypeMismatchException e) {
        logger.error("MethodArgumentTypeMismatchException: " + e.getParameter());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ArithmeticException.class})
    public ResponseEntity<Object> handleException(@NotNull ArithmeticException e) {
        logger.error("ArithmeticException: " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Object> handleException(@NotNull IllegalArgumentException e) {
        logger.error("IllegalArgumentException: " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /*Other Exceptions handler*/

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(@NotNull Exception e) {
        logger.error("Unexpected error: " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
