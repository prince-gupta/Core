package com.company.concurrency.callable;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Pgupta on 11/23/2014.
 */
public class MyFutureTask {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("120");
        FutureTask task = new FutureTask(new Task<BigInteger>(bi));
        System.out.println("Starting");
        task.run();
        System.out.println("Done");
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
