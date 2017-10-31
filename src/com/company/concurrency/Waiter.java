package com.company.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Pgupta on 8/20/2014.
 */
public class Waiter implements Runnable{
    private CountDownLatch latch ;
    Waiter(CountDownLatch latch){
        this.latch = latch;
    }

    public void run(){
        try{
            latch.await();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Waiter released");
    }
}
