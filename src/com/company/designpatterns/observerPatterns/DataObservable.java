package com.company.designpatterns.observerPatterns;

import java.util.Observable;

/**
 * Created by Pgupta on 2/28/2015.
 */
public class DataObservable extends Observable implements Runnable{
    public void start(){
        new Thread(this).start();
    }

    public void run(){
        int count = 0 ;
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){

        }
        count++;
        setChanged();
        notifyObservers(new Integer(count));
    }
}
