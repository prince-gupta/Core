package com.company.concurrency.pooling.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pgupta on 11/29/2014.
 */
public class ExcutorsLifeCycle {
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    public void start(){
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");
        Task task4 = new Task("Task 4");
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);
    }
    public void stop(){
        executorService.shutdown();
        try {
            if(executorService.isShutdown()){
                System.out.println("Services are shutting Down. Please wait . . .");
            }
            executorService.awaitTermination(20, TimeUnit.SECONDS);
            if(executorService.isTerminated()){
                System.out.println("Bye Bye :-)");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopNow(){
        executorService.shutdownNow();
        if(executorService.isTerminated()){
            System.out.println("Shutdown Abruptly . . .");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExcutorsLifeCycle excutorsLifeCycle = new ExcutorsLifeCycle();
        excutorsLifeCycle.start();
        excutorsLifeCycle.executorService.shutdown();
        System.out.println("isShutdown() : " + excutorsLifeCycle.executorService.isShutdown());
        excutorsLifeCycle.executorService.awaitTermination(100000, TimeUnit.SECONDS);
        //Thread.sleep(30000);
        if(excutorsLifeCycle.executorService.isTerminated()){
            System.out.println("Bye Bye :-)");
        }
    }

}
