package com.company.test;

/**
 * Created by Pgupta on 4/5/2015.
 */
public enum CompanyEnum {
    XEBIA(123.34, "Gurgaon"), GOOGLE(2345, "CA");
    public double value;
    public String address;

    private CompanyEnum(double value, String address) {
        this.value = value;
        this.address = address;
    }

}
