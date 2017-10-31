package com.company.concurrency.queues.delayQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * Created by Pgupta on 4/8/2015.
 */
public class DelayedQueueMain {
    public static void main(String[] args) {
        BlockingQueue delayedQueue = new DelayQueue();

        DelayQueueProducer delayQueueProducer = new DelayQueueProducer(delayedQueue);
        DelayedQueueConsumer delayedQueueConsumer = new DelayedQueueConsumer("Thread 1 ", delayedQueue);

        delayQueueProducer.start();
        delayedQueueConsumer.start();
    }
}
