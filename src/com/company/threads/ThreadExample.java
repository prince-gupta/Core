package com.company.threads;

/**
 * Created by Pgupta on 4/9/2015.
 */
public class ThreadExample {

    volatile int status=1;

    public static void main(String[] args) {
        ThreadExample threadExample = new ThreadExample();
        /*ThreadA threadA = new ThreadA(threadExample);
        ThreadB threadB = new ThreadB(threadExample);
        ThreadC threadC = new ThreadC(threadExample);

        threadA.start();
        threadB.start();
        threadC.start();*/
        CommonThreadABC threadABC = new CommonThreadABC(threadExample);
        threadABC.start();
        }
}
