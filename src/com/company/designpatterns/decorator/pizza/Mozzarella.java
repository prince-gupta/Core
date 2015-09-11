package com.company.designpatterns.decorator.pizza;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class Mozzarella extends PizzaDecorator {
    Mozzarella(Pizza pizza) {
        super(pizza);

        System.out.println("Adding Dough");
        System.out.println("Adding Mozzarella");
    }

    @Override
    public String description(){
        return pizza.description() + " Dough, Mozzarella";
    }

    @Override
    public double cost(){
        return pizza.cost() + 0.43;
    }
}
