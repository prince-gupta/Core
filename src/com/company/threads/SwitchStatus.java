package com.company.threads;

/**
 * Created by Pgupta on 4/9/2015.
 */
public class SwitchStatus extends Thread {
    private static String currentThread = "A";
    private static byte [] lock = new byte [0];
    private String name = "";
    private int count = 10;

    public SwitchStatus (String name) {
        this.name = name;
    }

    public void run () {
        while (count> 0) {
            synchronized (lock) {
                 if (currentThread.equals (this.name)) {
                    System.out.println (name);
                    count --;
                    if (currentThread.equals("A")) {
                        currentThread = "B";
                    } else if (currentThread.equals ("B")) {
                        currentThread = "C";
                    } else if (currentThread.equals ("C")) {
                        currentThread = "A";
                        System.out.println ();
                    }
                }
            }
        }
    }


    public static void main (String [] args) {
        (new SwitchStatus ("A")). start ();
        (new SwitchStatus ("B")). start ();
        (new SwitchStatus ("C")). start ();
    }
}
