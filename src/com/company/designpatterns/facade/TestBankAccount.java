package com.company.designpatterns.facade;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class TestBankAccount {
    public static void main(String[] args) {
        BankAccountFacade bankAccountFacade = new BankAccountFacade(123456789,1234);
        bankAccountFacade.cashWithdraw(50);
        bankAccountFacade.cashWithdraw(900);
        bankAccountFacade.cashDeposite(-1500);
        bankAccountFacade.cashWithdraw(2000);
    }
}
