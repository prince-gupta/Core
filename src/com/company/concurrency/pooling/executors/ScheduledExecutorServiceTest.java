package com.company.concurrency.pooling.executors;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pgupta on 4/7/2015.
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        scheduledExecutorService.schedule(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("Called At : " + new Date(System.currentTimeMillis()));
                return "Called!!";
            }
        }, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable(){

            @Override
            public void run() {
                System.out.println("Called At Fixed Rate .");
            }
        }, 5 ,2,TimeUnit.SECONDS);
    }
}
