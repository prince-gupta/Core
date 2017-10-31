package com.company.test.oops.problem1;

/**
 * Created by Pgupta on 05-10-2016.
 */
public class Child extends Parent{
    /*public String printM(){
        return "";
    }*/

    public static void print(){
        System.out.println("From Child");
    }

    public static void main(String[] args) {
        Parent p = new Child();

    }
}
