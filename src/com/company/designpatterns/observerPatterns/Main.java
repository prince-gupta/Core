package com.company.designpatterns.observerPatterns;

/**
 * Created by Pgupta on 2/28/2015.
 */
public class Main {
    public static void main(String[] args) {
        DataObservable observable = new DataObservable();
        DataObserver dataObserver = new DataObserver();
        observable.addObserver(dataObserver);
        observable.start();
        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException r){
            r.printStackTrace();
        }
    }
}
