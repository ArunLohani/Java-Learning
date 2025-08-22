package com.Exception.demo.controller;


import com.Exception.demo.exception.CustomException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping
    public ResponseEntity<String> start(){
        return  new ResponseEntity("Your App is Working",HttpStatus.OK);
    }


    @GetMapping("/hello")
    public ResponseEntity<?> Greet(){

        //Without @ExceptionHandler Annotation Defined in Controller Level or Global Level
        //this will be handled by defaultExpetionResolver of SpringBoot and will always give InternalServerError
        throw new CustomException("Invalid Url", HttpStatus.BAD_REQUEST);


    }



    //Exception Response will be a String - Invalid Url with status code 400
//    @ExceptionHandler(CustomException.class)
//    public ResponseEntity<String>handleCustomException(CustomException ex){
//
//        return new  ResponseEntity<>(ex.getMessage(),ex.getStatusCode());
//
//
//    }


    //Error Response will be an Object now {
    //    "statusCode": "BAD_REQUEST",
    //    "message": "Invalid Url",
    //    "timeStamp": "2025-08-20T05:55:44.837+00:00"
    //}
//    @ExceptionHandler(CustomException.class)
//    public ResponseEntity<ErrorResponse>handleCustomException(CustomException ex){
//
//        ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode(),ex.getMessage(),new Date());
//
//        return new  ResponseEntity<>(errorResponse,ex.getStatusCode());
//
//
//    }


    //using Response.sendError instead of ResponseEntity
//    {
//        "timestamp": "2025-08-20T06:02:10.912+00:00",
//            "status": 400,
//            "error": "Bad Request",
//            "path": "/api/hello"
//    }
//        @ExceptionHandler(CustomException.class)
//    public void handleCustomException(HttpServletResponse resp, CustomException ex) throws IOException {
//
//        resp.sendError(ex.getStatusCode().value(),ex.getMessage());
//
//
//
//    }


    //Response Status used with @ExceptionHandler
            @ExceptionHandler(CustomException.class)
            @ResponseStatus(value = HttpStatus.BAD_REQUEST , reason = "Unauthorized")
    public ResponseEntity<?> handleCustomException(HttpServletResponse resp, CustomException ex) throws IOException {

                return new  ResponseEntity<>(ex.getMessage(),ex.getStatusCode());



    }


}
