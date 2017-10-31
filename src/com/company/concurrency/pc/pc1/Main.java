package com.company.concurrency.pc.pc1;

/**
 * Created by Pgupta on 4/4/2015.
 */
public class Main {
    public static void main(String[] args) {
        Element element = new Element();
        Thread producer = new Thread(new Producer(element));
        Thread consumer = new Thread(new Consumer(element));
        producer.start();
        consumer.start();
    }
}
