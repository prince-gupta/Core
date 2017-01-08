package com.company.java.puzzlers;

import java.math.BigDecimal;

/**
 * Created by Pgupta on 11/22/2015.
 */
public class DoubleChange {
    public BigDecimal getCorrectValue(double value1, double value2){
        return new BigDecimal(""+value1).subtract(new BigDecimal(""+value2));
    }

    public double getWrongValue(double value1, double value2){
        return value1 - value2;
    }

    public static void main(String[] args) {
        DoubleChange dc = new DoubleChange();
        double value1 = 2.0d, value2 = 1.1d;

        System.out.println("Wrong Value : "+dc.getWrongValue(value1,value2));
        System.out.println("Correct Value : "+dc.getCorrectValue(value1,value2));
    }
}
