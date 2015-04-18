package com.company.designpatterns.decorator;

/**
 * Created by Pgupta on 4/5/2015.
 */
public class SportCar extends CarDecorator {

    public SportCar(Car c){
        super(c);
    }

    @Override
    public void assemble(){
        car.assemble();
        System.out.print(" Adding features of Sport Car.");
    }
}
