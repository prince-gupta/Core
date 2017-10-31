package com.company.concurrency.pc;

/**
 * Created by Pgupta on 8/10/2014.
 */
public class Consumer implements Runnable {
    private Element element;
    private int number;

    Consumer(Element element, int number){
        this.element = element;
        this.number = number;
    }

    public void run(){
        int value = 0;
        for(int i =0; i <= 10;i++){
            value = element.get();
            System.out.println("Consumer "+ number+" got : " + value);
        }
    }
}
