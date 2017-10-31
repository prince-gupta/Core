package com.company.concurrency.pc.pc1;

/**
 * Created by Pgupta on 4/4/2015.
 */
public class Producer implements Runnable{

    Element element;
    Producer(Element element){
        this.element = element;
    }

    public void run(){
        int i =0;
        while(true){
            synchronized (element) {
                if (element.getValue() != null) {
                    try {
                        System.out.print("Waiting");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    element.setValue(" " + i);
                    System.out.println("Produced : " + i);
                    notifyAll();
                i++;
            }
        }
    }
}
