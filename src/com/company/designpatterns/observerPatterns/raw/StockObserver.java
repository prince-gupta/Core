package com.company.designpatterns.observerPatterns.raw;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class StockObserver implements Observer {

    private double ibmPrice;
    private double applPrice;
    private double googPrice;

    private static int obeserverIdTracker =0;
    private int obeserverId;

    private StockGrabber stockGrabber;

    public StockObserver(StockGrabber stockGrabber){
        this.stockGrabber = stockGrabber;
        this.obeserverId = ++ obeserverIdTracker;
        System.out.println( "New Observer " + obeserverId);
        stockGrabber.register(this);
    }
    @Override
    public void update(double ibmPrice, double applPrice, double googPrice) {
        this.ibmPrice = ibmPrice;
        this.applPrice = applPrice;
        this.googPrice = googPrice;
        printPrices();
    }

    private void printPrices(){
        System.out.println(obeserverId + "\n IBM : " + ibmPrice + "\n Apple : " + applPrice + "\n Google : " + googPrice);
    }
}
