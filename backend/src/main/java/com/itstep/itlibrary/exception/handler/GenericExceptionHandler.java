package com.itstep.itlibrary.exception.handler;

import com.itstep.itlibrary.exception.AuthenticationRequiredException;
import com.itstep.itlibrary.exception.InternalServerException;
import com.itstep.itlibrary.exception.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleItemNotFoundException(ItemNotFoundException exception, WebRequest webRequest) {
        log.debug(exception.getMessage());
        var status = NOT_FOUND;
        return new ResponseEntity<>(new ErrorResponse(status.value(), exception.getMessage()), status);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ErrorResponse> handleInternalServerException(InternalServerException exception, WebRequest webRequest) {
        log.error(exception.getMessage());
        var status = INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponse(status.value(), exception.getMessage()), status);
    }

    @ExceptionHandler(AuthenticationRequiredException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationRequiredException(AuthenticationRequiredException exception, WebRequest webRequest) {
        log.debug(exception.getMessage());
        var status = UNAUTHORIZED;
        return new ResponseEntity<>(new ErrorResponse(status.value(), exception.getMessage()), status);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationException exception, WebRequest webRequest) {
        log.debug(exception.getMessage());
        var status = UNAUTHORIZED;
        return new ResponseEntity<>(new ErrorResponse(status.value(), exception.getMessage()), status);
    }

}
