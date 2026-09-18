package com.pesaflow.dto;


public class ErrorResponse {
    private int status;
    private String message;
    public ErrorResponse(String message ,int status){
        this.status=status;
        this.message=message;
    }
    public String getMessage(){
        return message;
    }
    public int getStatus(){
        return status;
    }

    }
