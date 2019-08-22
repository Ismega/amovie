package com.ecjtu.mega.amovie.exception;

import com.ecjtu.mega.amovie.constant.CommonCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author mega
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = CommonException.class)
    public ResponseEntity getException(CommonException common) {
        return new ResponseEntity(CommonCode.error(common.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
