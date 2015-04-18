package com.company.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Pgupta on 8/20/2014.
 */
public class Task implements Runnable {
    private java.util.concurrent.CyclicBarrier cyclicBarrier;
    Task(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " has reached the Barrier.");
            long prevTime = System.currentTimeMillis();
            Thread.sleep((long)(1000*Math.random()));
            cyclicBarrier.await();
            System.out.println("Thread " + Thread.currentThread().getName() + " has crossed the Barrier. And taken " + (System.currentTimeMillis() - prevTime));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
