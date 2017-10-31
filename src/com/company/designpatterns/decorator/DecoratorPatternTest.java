package com.company.designpatterns.decorator;

/**
 * Created by Pgupta on 4/5/2015.
 */
public class DecoratorPatternTest {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar(new BasicCar());
        sportCar.assemble();
        System.out.print("\n");

        SportCar sportCumLuxeryCar = new SportCar(new LuxeryCar(new BasicCar()));
        sportCumLuxeryCar.assemble();
    }
}
