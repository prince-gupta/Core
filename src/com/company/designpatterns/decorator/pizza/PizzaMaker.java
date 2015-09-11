package com.company.designpatterns.decorator.pizza;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class PizzaMaker {
    public static void main(String[] args) {
        Pizza pizza = new ExtraCheese(new Mozzarella(new BasicPizza()));
        System.out.println("Contents : " + pizza.description());
        System.out.println("Cost : " + pizza.cost());
    }
}
