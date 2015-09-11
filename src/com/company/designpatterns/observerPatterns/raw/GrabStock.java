package com.company.designpatterns.observerPatterns.raw;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class GrabStock {
    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();

        StockObserver observer1 = new StockObserver(stockGrabber);
        stockGrabber.setIbmPrice(123.54d);
        stockGrabber.setApplePrice(234.21d);
        stockGrabber.setGoogPrice(134.32d);

    }
}
