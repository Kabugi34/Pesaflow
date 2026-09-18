package com.pesaflow.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.pesaflow.dto.ErrorResponse;


@RestControllerAdvice 
public class GlobalExceptionHandler {
    @ExceptionHandler (UserNotFoundException.class)
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFound(UserNotFoundException exception){
        return new ErrorResponse(
            exception.getMessage(), 404
        );
    }

}
