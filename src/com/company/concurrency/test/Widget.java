package com.company.concurrency.test;

/**
 * Created by Pgupta on 10/30/2015.
 */
public class Widget {
    public synchronized void doSomething(){
        System.out.println(toString() + "Called");
    }
}
