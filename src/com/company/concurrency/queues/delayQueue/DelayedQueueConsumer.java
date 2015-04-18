package com.company.concurrency.queues.delayQueue;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Pgupta on 4/8/2015.
 */
public class DelayedQueueConsumer {

    private BlockingQueue queue;
    private String threadName;

    public DelayedQueueConsumer(String threadName, BlockingQueue queue){
        this.queue = queue;
        this.threadName = threadName;
    }

    private Thread consumerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    DelayedElement delayedElement = (DelayedElement)queue.take();
                    System.out.println("Fetched ITem : " + delayedElement +
                            " By Thread : " + Thread.currentThread().getName() +
                            " at " + new Date(System.currentTimeMillis()));
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    public void start(){
        consumerThread.setName(threadName);
        consumerThread.start();
    }
}
