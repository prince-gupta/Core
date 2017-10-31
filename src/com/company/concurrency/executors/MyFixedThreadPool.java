package com.company.concurrency.executors;

/**
 * Created by princegupta on 19/08/17.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyFixedThreadPool {

    public static void main(String[] args) {
        sleepSeconds(10); // give 10 seconds to connect to JVisualMV

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        newFixedThreadPool.submit(() -> sleepSeconds(5)); // starts only first thread
        sleepSeconds(6); // wait 6s so first thread finishes running the task
        newFixedThreadPool.submit(() -> sleepSeconds(5)); // starts 2nd thread to process 2nd task even
        // though 1st thread already finished processing
        // 1st task and was available/waiting
        sleepSeconds(1); // wait 1s to add 3rd task
        newFixedThreadPool.submit(() -> sleepSeconds(5)); // 3rd task is picked by the 1st thread
        // (1st thread was awailable/waiting)
        sleepSeconds(1); // wait 1s to add 4rd task
        newFixedThreadPool.submit(() -> sleepSeconds(5)); // need to wait 3s for available
        // thread before processing 4rd task

        sleepSeconds(80); // wait until all threads finish processing tasks + additional 60 seconds
    }

    private static void sleepSeconds(int seconds) {
        try {
            System.out.println(currentThreadId() + "About to sleep "+seconds+" seconds");
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String currentThreadId() {
        long id = Thread.currentThread().getId();
        return String.format("Thread id=%-2s|", id);
    }
}