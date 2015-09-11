package com.company.designpatterns.facade;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class BankAccountFacade {
    private int accountNumber;
    private int securityCode;

    private AccountNumberChecker accountNumberChecker;
    private SecurityCodeChecker codeChecker;
    private FundsHandler fundsHandler;

    BankAccountFacade(int accountNumber, int securityCode) {
        this.accountNumber = accountNumber;
        this.securityCode = securityCode;
        this.accountNumberChecker = new AccountNumberChecker();
        this.codeChecker = new SecurityCodeChecker();
        this.fundsHandler = new FundsHandler();
    }

    public void cashWithdraw(double amount){
        if(accountNumberChecker.isAccountNumberValid(this.accountNumber)
                && codeChecker.isCodeValid(this.securityCode)){
            fundsHandler.withdraw(amount);
        }

    }

    public void cashDeposite(double amount){
        if(accountNumberChecker.isAccountNumberValid(this.accountNumber)
                && codeChecker.isCodeValid(this.securityCode)){
            fundsHandler.deposite(amount);
        }

    }
}
