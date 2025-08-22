package com.Exception.demo.exception;

import com.Exception.demo.controller.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Date;

//Global Level Exception handler
//@ControllerAdvice
public class GlobalException {

        @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse>handleCustomException(CustomException ex){

        ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode(),ex.getMessage(),new Date());

        return new ResponseEntity<>(errorResponse,ex.getStatusCode());


    }

}
