package com.company.designpatterns.observerPatterns.raw;

import java.util.ArrayList;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class StockGrabber implements Subject {

    ArrayList<Observer> observers ;
    double ibmPrice;
    double applePrice;
    double googPrice;

    StockGrabber(){
        observers = new ArrayList<Observer>();

    }
    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
        int observerIndex = observers.indexOf(observer);
        System.out.println("Observer " + observerIndex + 1 + "deleted");
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update(ibmPrice,applePrice,googPrice);
        }
    }

    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
         notifyObserver();
    }

    public void setApplePrice(double applePrice) {
        this.applePrice = applePrice;
        notifyObserver();
    }

    public void setGoogPrice(double googPrice) {
        this.googPrice = googPrice;
        notifyObserver();
    }
}