package com.ecjtu.mega.amovie.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = CommonException.class)
    public void getException(CommonException common) {
        System.err.println(common.getMessage()+"66666");
    }
}
