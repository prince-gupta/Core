package com.company.concurrency.pc;

/**
 * Created by Pgupta on 8/10/2014.
 */
public class Main {
    public static void main(String[] args) {
        Element element = new Element();
        Thread p1 = new Thread(new Producer(element,1));
        Thread c1 = new Thread(new Consumer(element,1));
        Thread c2 = new Thread(new Consumer(element,2));
        p1.start();
        c1.start();
        c2.start();
    }
}
