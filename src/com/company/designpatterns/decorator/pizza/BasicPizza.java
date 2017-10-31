package com.company.designpatterns.decorator.pizza;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class BasicPizza implements Pizza {
    @Override
    public String description() {
        return ("Bread , Cheese");
    }

    @Override
    public double cost() {
        return 4.45;
    }
}
