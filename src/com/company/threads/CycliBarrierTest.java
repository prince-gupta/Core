package com.company.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Pgupta on 4/9/2015.
 */
public class CycliBarrierTest implements Runnable {
    private static List list = new ArrayList(3);
    private CyclicBarrier barrier;
    private String name = "";

    public CycliBarrierTest(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                list.add(name);
                this.barrier.await();// thread runs this point checks whether other threads are in attendance, not in attendance to continue to wait. Attendance on the implementation of the run of the barrier function body
            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        // Parameter 3 represents three threads have reached the starting line began to continue down the implementation of
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            public void run() {
                Collections.sort(list);
                for (int i = 0, n = list.size(); i < n; i++) {
                    System.out.print(list.get(i));
                }
                list.clear();
                System.out.println();
            }
        });
        Thread t1 = new Thread(new CycliBarrierTest(barrier, "A"));
        Thread t2 = new Thread(new CycliBarrierTest(barrier, "B"));
        Thread t3 = new Thread(new CycliBarrierTest(barrier, "C"));
        t1.start();
        t2.start();
        t3.start();
    }

}
