package com.company.designpatterns.facade;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class FundsHandler {
    private double cashInAccount = 1000.00;

    public double getCashInAccount(){
        return this.cashInAccount;
    }

    public void increaseCash(double cashToDeposite){
        cashInAccount += cashToDeposite;
    }

    public void decreaseCash(double cashToWithdraw){
        cashInAccount -= cashToWithdraw;
    }

    public boolean haveEnoughMoney(double cashToWithdraw){
        if(cashToWithdraw > getCashInAccount()){
            System.out.println("Error : Insufficient funds !!! :-(");
            System.out.println("Available Balance : " + getCashInAccount());
            return false;
        }
        return true;
    }

    public void withdraw(double moneyToWithdraw){
        if(haveEnoughMoney(moneyToWithdraw)) {
            decreaseCash(moneyToWithdraw);
            System.out.println("Transaction Successful . \nRemaining Balance = " + getCashInAccount());
        }
    }

    public void deposite(double moneyToDeposite){
        if(moneyToDeposite > 0){
            increaseCash(moneyToDeposite);
            System.out.println("Transaction Successful . /nRemaining Balance = " + getCashInAccount());
        }
        else{
            System.out.println("Error : Invalid amount !!!");
        }
    }
}
