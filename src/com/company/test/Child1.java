package com.company.test;

import java.io.FileNotFoundException;

/**
 * Created by Pgupta on 8/6/2014.
 */
public class Child1 extends Parent{
    private String name;

    public Child1(String name, String name1) {
        super(name,25);
        name = name1;
    }

    public String getName() {
        return name;
    }

    public void crunch() throws RuntimeException{

    }

    public void setName(String name) {
        this.name = name;
    }

    public Child1(String name) {
        this.name = name;
    }
}
