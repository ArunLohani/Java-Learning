package com.Exception.demo.controller;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorResponse {

    private HttpStatus statusCode;
    private String message;
    private Date timeStamp;

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ErrorResponse(HttpStatus statusCode, String message, Date timeStamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
