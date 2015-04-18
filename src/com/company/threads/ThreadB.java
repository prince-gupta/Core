package com.company.threads;

/**
 * Created by Pgupta on 4/9/2015.
 */
public class ThreadB extends Thread{

    ThreadExample thread ;
    ThreadB(ThreadExample thread){
        this.thread = thread;
    }

    public void run(){
        try{
            synchronized (thread){
                for(int i =0; i< 10;i++) {
                    while (thread.status != 2) {
                        thread.wait();
                    }
                    System.out.println("B");
                    thread.status = 3;
                    thread.notifyAll();
                }
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
