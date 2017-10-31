package com.company.designpatterns.decorator.pizza;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class ExtraCheese extends PizzaDecorator {
    ExtraCheese(Pizza pizza) {
        super(pizza);
        System.out.println("Adding extra cheese");
    }

    @Override
    public String description(){
        return pizza.description() + "Extra Cheese";
    }

    @Override
    public double cost(){
        return pizza.cost() + 5;
    }
}
