package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

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

        Map<Key, Integer> weakHM = new WeakHashMap<>();
        Key key1 = new Key();
        key1.setName("1");
        Key key2 = new Key();
        key2.setName("2");

        weakHM.put(key1, 1);
        weakHM.put(key2, 2);

        Map<Key, Integer> hm = new HashMap<>();

      //  hm.put(key1, 1);
        hm.put(key2, 2);


        key1 = null;
        System.gc();
        for (final Map.Entry<Key, Integer> entry : weakHM.entrySet()) {
            System.out.println(entry.getKey().getName() + "   " + entry.getValue());
        }

        for (final Map.Entry<Key, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey().getName() + "   " + entry.getValue());
        }


    }

    public void simulateCallback(InnerInterface innerInterface) {
        innerInterface.printMessage();
    }

    interface InnerInterface {
        public void printMessage();
    }

    public static class Key {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
