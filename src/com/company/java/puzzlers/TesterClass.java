package com.company.java.puzzlers;

/**
 * Created by Pgupta on 11/22/2015.
 */
public class TesterClass {
    public static void main(String[] args) {
        String g = "hello";
        DummyClass dc = new DummyClass(3);
        g += dc;
    }
}
