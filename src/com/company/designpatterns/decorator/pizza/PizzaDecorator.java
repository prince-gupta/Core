package com.company.designpatterns.decorator.pizza;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class PizzaDecorator implements Pizza {

    Pizza pizza;

    PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }
    @Override
    public String description() {
        return pizza.description();
    }

    @Override
    public double cost() {
        return pizza.cost();
    }
}
