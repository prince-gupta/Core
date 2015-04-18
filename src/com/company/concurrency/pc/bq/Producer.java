package com.company.concurrency.pc.bq;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Pgupta on 8/10/2014.
 */
public class Producer extends Thread{
    private BlockingQueue queue;

    Producer(BlockingQueue queue){
        this.queue = queue;
    }

    public void run(){
        for(int i = 0 ; i <= 10 ; i++){
            System.out.println("Produced : "+i);
            queue.add(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
