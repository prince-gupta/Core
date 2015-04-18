package com.company.designpatterns.decorator;

/**
 * Created by Pgupta on 4/5/2015.
 */
public class CarDecorator implements Car {

    protected Car car;
     public CarDecorator(Car car){
         this.car = car;
     }

    @Override
    public void assemble(){
        this.car.assemble();
    }
}
