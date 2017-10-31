package com.company.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Pgupta on 8/20/2014.
 */
public class CountDownLatchMain {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        Waiter waiter = new Waiter(countDownLatch);
        Decrementer decrementer = new Decrementer(countDownLatch);
        Thread waiterThread = new Thread(waiter);
        Thread decrementerThread = new Thread(decrementer);
        waiterThread.start();
        decrementerThread.start();
    }
}
