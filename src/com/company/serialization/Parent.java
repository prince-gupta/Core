package com.company.serialization;

import java.util.Date;

/**
 * Created by Pgupta on 9/14/2015.
 */
public class Parent {
    Date d ;
    int a;

    public Parent(){}

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Parent(Date d, int a) {
        this.d = d;
        this.a = a;

    }
}
