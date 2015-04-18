package com.company.concurrency.lock.ordering.ordering;

/**
 * Created by Pgupta on 2/8/2015.
 */
public class Account {
    float balance;

    public void debit(float amount){
        this.balance -= amount;
    }

    public void credit(float amount){
        this.balance += amount;
    }

    public float getBalance(){
        return this.balance;
    }

    public void setBalance(float intialBalance){
        this.balance = intialBalance;
    }
}
