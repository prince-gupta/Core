package com.company;

import java.util.TreeMap;

/**
 * Created by Pgupta on 28-04-2016.
 */
public class Test2 {
    public static void main(String args[]) {
        int[] arr = {10, 40, 20};
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int index = 0;
        for (int value : map.values()) {
            arr[index] = value;
            System.out.println(arr[index]);
            index++;
        }

        Double d = 123d;
        System.out.println(d.toString());

        int a = 7;
        int b = ++a;
        int c = a++;
        System.out.println(c);

        Test2 t2 = new Test2();
        t2.simulateCallback(new InnerInterface() {
            @Override
            public void printMessage() {
                System.out.println("Hello");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Hi");
    }

    public void simulateCallback(InnerInterface innerInterface) {
        innerInterface.printMessage();
    }

    interface InnerInterface {
        public void printMessage();
    }
}
