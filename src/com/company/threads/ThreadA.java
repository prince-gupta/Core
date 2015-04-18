package com.company.threads;

/**
 * Created by Pgupta on 4/9/2015.
 */
public class ThreadA extends Thread{
    ThreadExample thread ;

    ThreadA(ThreadExample thread){
        this.thread = thread;
    }

    public void run(){
        try {
            synchronized (thread) {
                for(int i =0; i< 10;i++) {
                    while (thread.status != 1) {
                        thread.wait();
                    }
                    System.out.println("A");
                    thread.status = 2;
                    thread.notifyAll();
                }
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
