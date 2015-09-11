package com.company.designpatterns.observerPatterns.raw;

/**
 * Created by Pgupta on 9/11/2015.
 */
public interface Subject {

    public void register(Observer observer);
    public void unRegister(Observer observer);
    public void notifyObserver();
}
