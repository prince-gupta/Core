package com.company.threads;

/**
 * Created by Pgupta on 4/9/2015.
 */
public class MyThread extends Thread {
    private static Object o = new Object();
    private static int count = 0;
    private char ID;
    private int id;
    private int num = 0;

    public MyThread(int id, char ID) {
        this.id = id;
        this.ID = ID;
    }

    public void run() {
        synchronized (o) {
            while (num < 10) {
                if (count % 3 == id) {
                    System.out.println(ID);
                    ++count;
                    ++num;
                    o.notifyAll();
                } else {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        (new MyThread(0, 'A')).start();
        (new MyThread(1, 'B')).start();
        (new MyThread(2, 'C')).start();
    }
}