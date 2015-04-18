package com.company.concurrency.pc.bq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Pgupta on 8/10/2014.
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        Producer producer = new Producer(blockingQueue);
        Producer producer1 = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        producer.start();
        producer1.start();
        consumer.start();
    }
}
