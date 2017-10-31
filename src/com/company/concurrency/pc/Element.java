package com.company.concurrency.pc;

/**
 * Created by Pgupta on 8/10/2014.
 */
public class Element {
    private int content;
    private boolean available = false;

    public synchronized int get(){
        if(available == false){
            System.out.println("Waiting to get produced .");
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return content;
    }

    public synchronized void put(int content){
        if(available == true){
            System.out.println("Waiting to get Consumed .");
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        available = true;
        this.content = content;
        notifyAll();
    }
}
