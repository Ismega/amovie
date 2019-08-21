package com.ecjtu.mega.amovie.exception;

import com.ecjtu.mega.amovie.constant.CommonCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity getException(NotFoundException e) {

        return new ResponseEntity(CommonCode.error(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
