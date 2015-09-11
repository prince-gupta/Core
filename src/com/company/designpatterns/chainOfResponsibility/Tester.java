package com.company.designpatterns.chainOfResponsibility;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class Tester {
    public static void main(String[] args) {
        Numbers numbers = new Numbers(3,5,
                "mul");
        Chain addNumbers = new AddNumbers();
        Chain subNumbers = new SubstractNumbers();
        Chain mulNumbers = new MultiplyNumbers();
        Chain divNumbers = new DivideNumbers();
        addNumbers.setNextChain(subNumbers);
        subNumbers.setNextChain(mulNumbers);
        mulNumbers.setNextChain(divNumbers);

        addNumbers.calculate(numbers);

    }
}
