package com.example.demo.ControllerGlobalException;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String allexceptionHandler(Exception e){
        log.info("Global Exception Handler"+e);
        return "global_error";
    }
}
