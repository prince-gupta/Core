package com.company.designpatterns.chainOfResponsibility;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class AddNumbers implements Chain {

    private Chain nextChain;

    @Override
    public void setNextChain(Chain chain) {
        this.nextChain = chain;
    }

    @Override
    public void calculate(Numbers numbers) {
        if (numbers.getCalculationWanted() == "add") {
            System.out.println(numbers.getNumber1() + " + " + numbers.getNumber2() + " = " + (numbers.getNumber1() + numbers.getNumber2()));
        }
        else{
            nextChain.calculate(numbers);
        }
    }
}
