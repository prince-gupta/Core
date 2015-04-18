package com.company.threads;

/**
 * Created by Pgupta on 4/9/2015.
 */
public class ThreadC extends Thread{

    ThreadExample thread;

    public ThreadC(ThreadExample thread){
        this.thread = thread;
    }
    public void run(){
        try{
            synchronized (thread) {
                for(int i =0; i< 10;i++) {
                    while (thread.status != 3) {
                        thread.wait();
                    }
                    System.out.println("C");
                    thread.status = 1;
                    thread.notifyAll();
                }
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
