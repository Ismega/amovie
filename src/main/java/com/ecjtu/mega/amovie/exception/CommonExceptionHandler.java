package com.ecjtu.mega.amovie.exception;

import com.ecjtu.mega.amovie.constant.CommonCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = CommonException.class)
    public ResponseEntity getException(CommonException common) {
//        System.err.println(common.getMessage()+"66666");
        return new ResponseEntity(CommonCode.error(common.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
