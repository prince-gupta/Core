package com.company.concurrency.queues.delayQueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Pgupta on 4/8/2015.
 */
public class DelayQueueProducer {

    private BlockingQueue queue;
    private Random random = new Random();
    public DelayQueueProducer(BlockingQueue queue){
        this.queue = queue;
    }

    private Thread producerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            int delayCount = 3;
            while(true){
                if(delayCount > 10)
                    break;
                int delay = random.nextInt(5000);
                DelayedElement delayedElement = new DelayedElement(UUID.randomUUID().toString()+" delay : " + delay,delay*delayCount);
                System.out.println("Added Item : " + delayedElement);
                queue.add(delayedElement);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                delayCount ++;
            }
        }
    });

    public void start(){
        this.producerThread.start();
    }
}
