package com.company.designpatterns.facade;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class AccountNumberChecker {
    private int accountNumber = 123456789;

    public boolean isAccountNumberValid(int accountNumber){
        return accountNumber == this.accountNumber;
    }
}
