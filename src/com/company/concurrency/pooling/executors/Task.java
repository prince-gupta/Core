package com.company.concurrency.pooling.executors;

/**
 * Created by Pgupta on 11/29/2014.
 */
public class Task implements Runnable {
    String name ;
    Task(String name){
        this.name = name;
    }
    public void run(){
        try {
            System.out.println(name + " going to execute the task.");
            Thread.sleep(10000);
            System.out.println(name + " has finished task.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
