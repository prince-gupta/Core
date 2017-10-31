package com.company.concurrency.queues.delayQueue;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pgupta on 4/8/2015.
 */
public class DelayedElement implements Delayed {

    String data;
    long startTime;

    public DelayedElement(String data, long delay){
        this.data = data;
        this.startTime = System.currentTimeMillis() + delay;
    }

    @Override
    public long getDelay(TimeUnit unit){
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff,TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed delayed){
        if(this.startTime > ((DelayedElement)delayed).startTime){
            return 1;
        }
        if(this.startTime < ((DelayedElement)delayed).startTime){
            return -1;
        }
            return 0;
    }

    @Override
    public String toString(){
        return "{ data = " + this.data + " : added at = " + new Date(this.startTime) + "}";
    }
}
