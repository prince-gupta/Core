package com.company.designpatterns.decorator;

/**
 * Created by Pgupta on 4/5/2015.
 */
public class BasicCar implements Car {

    @Override
    public void assemble(){
        System.out.print("Basic Car.");
    }
}
