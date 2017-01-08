package com.company.java.puzzlers;

/**
 * Created by Pgupta on 11/22/2015.
 */
public class LongDivision {
    public void printWrongValue() {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println("Wrong Value : "+MICROS_PER_DAY / MILLIS_PER_DAY);
    }

    public void printCorrectValue() {
        final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;
        System.out.println("Correct Value : "+MICROS_PER_DAY / MILLIS_PER_DAY);
    }

    public static void main(String[] args) {
        LongDivision ld = new LongDivision();
        ld.printWrongValue();
        ld.printCorrectValue();
    }
}
