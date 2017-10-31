package com.company.test.oops.problem1;

/**
 * Created by Pgupta on 31-08-2016.
 */
public class Main extends B implements A {
    public void printM(){
        super.printM();
        System.out.println("Main");
    }

    public static void main(String[] args) {
        new Main().printM();
    }
}
