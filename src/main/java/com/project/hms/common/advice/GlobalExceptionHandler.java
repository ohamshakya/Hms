package com.project.hms.common.advice;


import com.project.hms.common.exception.AlreadyExistsException;
import com.project.hms.common.exception.ResourceNotFoundException;
import com.project.hms.common.utils.ErrorResponse;
import com.project.hms.common.utils.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ResponseWrapper<String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ErrorResponse.buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({AlreadyExistsException.class})
    public ResponseEntity<ResponseWrapper<String>> handleAlreadyExistsException(AlreadyExistsException ex) {
        return ErrorResponse.buildErrorResponse(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
