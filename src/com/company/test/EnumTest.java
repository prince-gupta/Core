package com.company.test;

/**
 * Created by Pgupta on 4/5/2015.
 */
public class EnumTest {
    public static void main(String[] args) {
        for(CompanyEnum values : CompanyEnum.values())
        System.out.println(values + " : Stock = " + values.value + ", Address = " + values.address);
    }
}
