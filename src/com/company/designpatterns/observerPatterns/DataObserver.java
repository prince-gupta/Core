package com.company.designpatterns.observerPatterns;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Pgupta on 2/28/2015.
 */
public class DataObserver implements Observer {
    public void update(Observable observable, Object object){
        System.out.println("Update comes : " + (Integer)object);
    }
}
