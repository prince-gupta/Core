package com.company.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Pgupta on 8/20/2014.
 */
public class Decrementer implements Runnable {
    private CountDownLatch latch;
    Decrementer(CountDownLatch latch){
        this.latch = latch;
    }

    public void run(){
        try{
            /*Thread.sleep(2000);
            latch.countDown();
            System.out.println("Lock " + latch.getCount() + " released");
            Thread.sleep(2000);
            latch.countDown();
            System.out.println("Lock " + latch.getCount() + " released");
            Thread.sleep(2000);
            latch.countDown();
            System.out.println("Lock " + latch.getCount() + " released");
            Thread.sleep(2000);
            latch.countDown();
            System.out.println("Lock " + latch.getCount() + " released");*/
            for(int i = 0 ; i < 8; i++){
            Thread.sleep(500);
            latch.countDown();
            System.out.println("Lock " + latch.getCount() + " released");}
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
