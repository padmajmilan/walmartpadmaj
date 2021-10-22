package com.example.demo.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(value = WalmartExceptions.class)
    public ResponseEntity<Object> exception(WalmartExceptions except){

        log.info("No Employee found");
        return new ResponseEntity<Object>("No Employee found", HttpStatus.NOT_FOUND);

    }

}
