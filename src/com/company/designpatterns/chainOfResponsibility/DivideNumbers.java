package com.company.designpatterns.chainOfResponsibility;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class DivideNumbers implements Chain {

    private Chain nextChain;

    @Override
    public void setNextChain(Chain chain) {
        this.nextChain = chain;
    }

    @Override
    public void calculate(Numbers numbers) {
        if (numbers.getCalculationWanted() == "div") {
            System.out.println(numbers.getNumber1() + " / " + numbers.getNumber2() + " = " + (numbers.getNumber1() / numbers.getNumber2()));
        }
        else{
            System.out.println("Only Add, Substract , Multiply and Divide is supported.");
        }
    }
}
