/**
 * PlayFile - Web Project
 */
package com.user.management.crud.handlers;

import com.user.management.crud.responses.Error;
import com.user.management.crud.responses.ErrorResponse;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * Projeto - Blog Pessoal
 *
 * @since 28/08/2019
 * @author Tiago Lopes
 */
@RestControllerAdvice
public class BadRequestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Error> errors = getErrors(ex);
        ErrorResponse response = getErrorResponse(ex, status, errors, request);
        return new ResponseEntity<>(response, status);
    }

    private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<Error> errors, WebRequest request) {
        return new ErrorResponse(
                new Date(),
                "Request has invalid fields",
                status.value(),
                status.getReasonPhrase(),
                ex.getBindingResult().getObjectName(),
                request.getDescription(false),
                errors);
    }

    private List<Error> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new Error(error.getField(), error.getDefaultMessage(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

}
