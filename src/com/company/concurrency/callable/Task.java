package com.company.concurrency.callable;

import java.util.concurrent.Callable;

/**
 * Created by Pgupta on 11/23/2014.
 */
public class Task<T> implements Callable {
    T t ;
    public Task(T t){
        this.t = t;
    }
    public T call() throws InterruptedException {
        Thread.sleep(5000);
        return t;
    }
}
