package com.Exception.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter

//Response Status used above an Exception Class to handle uncaught exception
//@ResponseStatus(value = HttpStatus.BAD_REQUEST , reason = "Unauthorized")
public class CustomException extends RuntimeException {

  HttpStatus statusCode;

    public CustomException(String message , HttpStatus statusCode) {

      super(message);
      this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode(){
      return this.statusCode;
    }
}
