package com.company.concurrency.pc.pc1;

/**
 * Created by Pgupta on 4/4/2015.
 */
public class Consumer implements Runnable {
    Element element;

    Consumer(Element element){
        this.element = element;
    }

    public void run(){
        while(true) {
            synchronized (element) {
                if (element.getValue() == null) {
                    try {
                        System.out.println("Waiting to Produce");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    System.out.println("Consumed : " + element.getValue());
                    element.setValue(null);
                    notifyAll();
            }
        }
    }
}
