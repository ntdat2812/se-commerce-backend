package com.silly.ecommerce.common.exception;

import com.silly.ecommerce.common.response.ResultResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class SeExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        ResultResponse resultResponse = new ResultResponse(status.value(), errors.stream().findFirst().get());

        return new ResponseEntity<>(resultResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SeException.class)
    public ResponseEntity<ResultResponse> handleSeException(SeException ex) {

        ResultResponse resultResponse = new ResultResponse(ex.getStatus(), ex.getMessage());
        return new ResponseEntity<>(resultResponse, HttpStatus.valueOf(ex.getStatus()));
    }
}
