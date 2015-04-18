package com.company.threads;

/**
 * Created by Pgupta on 4/9/2015.
 */
public class CommonThreadABC extends Thread {

    ThreadExample thread ;
    int count =10;

    CommonThreadABC(ThreadExample thread){
        this.thread = thread;
    }

    public void run(){
        try{
            while(count > 0){
                synchronized (thread){
                    if(thread.status ==1){
                        System.out.println("A");
                        thread.status=2;
                    }
                    if(thread.status ==2){
                        System.out.println("B");
                        thread.status=3;
                    }
                    if(thread.status ==3){
                        System.out.println("C");
                        thread.status=1;
                    }
                }
                count --;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
