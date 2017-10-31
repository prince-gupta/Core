package com.company.test.java8;

/**
 * Created by princegupta on 24/08/17.
 */
public interface Interface2 extends Interface1{
    default void printMessage(){
        System.out.println("Hello");
    }
}
