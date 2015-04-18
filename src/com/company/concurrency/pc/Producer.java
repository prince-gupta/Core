package com.company.concurrency.pc;

/**
 * Created by Pgupta on 8/10/2014.
 */
public class Producer implements Runnable{
    private Element element;
    private int number;

    Producer(Element element, int number){
        this.element = element;
        this.number = number;
    }

    public void run(){
        for(int i =0 ; i<=10;i++){
            element.put(i);
            System.out.println("Producer " + number + " produces : " + i);
            try{
                Thread.sleep((int)(Math.random() * 1000));
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
