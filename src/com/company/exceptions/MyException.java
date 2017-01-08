package com.company.exceptions;

/**
 * Created by Pgupta on 10/30/2015.
 */
public class MyException extends NullPointerException {
    private String message;
    public MyException(String message){
        super(message);
        this.message = message;
    }
    public String toString(){
        return "MyException causes by : " + message;
    }
}
