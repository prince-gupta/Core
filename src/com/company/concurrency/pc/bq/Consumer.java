package com.company.concurrency.pc.bq;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Pgupta on 8/10/2014.
 */
public class Consumer extends Thread {
    private BlockingQueue queue;
     Consumer(BlockingQueue queue){
         this.queue = queue;
     }

    public void run(){
        while(true){
            try {
                System.out.println("Consumed : " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
