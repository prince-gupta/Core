package com.company.test;

import java.io.IOException;

/**
 * Created by Pgupta on 8/6/2014.
 */
public class Parent {
    public Parent(String name, int age) {
        this.name = name;this.age = age;
    }

    public Parent() {
    }

    public void crunch() throws IOException{

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parent)) return false;

        Parent parent = (Parent) o;

        if (name != null ? !name.equals(parent.name) : parent.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
