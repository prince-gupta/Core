package com.company.concurrency;

/**
 * Created by Pgupta on 8/20/2014.
 */
public class CyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        java.util.concurrent.CyclicBarrier cyclicBarrier = new java.util.concurrent.CyclicBarrier(3,new Runnable() {
            @Override
            public void run() {
                System.out.println("Every Thread has reached the barrier. Lets do some work");
            }
        });
        Thread thread1 = new Thread(new Task(cyclicBarrier), "Thread 1");
        Thread thread2 = new Thread(new Task(cyclicBarrier), "Thread 2");
        Thread thread3 = new Thread(new Task(cyclicBarrier), "Thread 3");
        thread1.start();
        Thread.sleep(5000);
        thread2.start();
        Thread.sleep(5000);
        thread3.start();
    }

}
