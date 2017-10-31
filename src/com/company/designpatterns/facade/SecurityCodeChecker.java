package com.company.designpatterns.facade;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class SecurityCodeChecker {
    private int code = 1234;

    public boolean isCodeValid(int code){
        return this.code == code;
    }
}
