package com.company.designpatterns.singleton;

/**
 * Created by Pgupta on 4/14/2015.
 */
public class Main {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s1 = Singleton.getInstance();

        System.out.println(s.hashCode() + " : " + s1.hashCode());
    }
}
