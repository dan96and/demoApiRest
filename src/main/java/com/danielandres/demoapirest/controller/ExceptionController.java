package com.danielandres.demoapirest.controller;

import com.danielandres.demoapirest.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ResponseUtil> handleExceptionController(ArithmeticException ae) {
        ResponseUtil responseUtil = ResponseUtil.builder().message(ae.getMessage()).errorCode(ResponseUtil.OBJECTS_EXISTS).build();
        return new ResponseEntity<>(responseUtil, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseUtil> IllegalArgumentExceptionController(IllegalArgumentException iae) {
        ResponseUtil responseUtil = ResponseUtil.builder().message(iae.getMessage()).errorCode(ResponseUtil.NOT_FOUND).build();
        return new ResponseEntity<>(responseUtil,HttpStatus.NOT_FOUND);
    }
}
