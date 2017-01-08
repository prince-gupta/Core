package com.company.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pgupta on 8/9/2014.
 */
public class GenericMain {
    public static void main(String[] args) {
        GenericClassA<String, Integer> a = new GenericClassA<String, Integer>();
        a.setE("ER");
        System.out.println(a.getE());
        try {
            a.setT(null);
        } catch (ErrorClass ec) {
            System.out.println("Null catch");
        }

        List l = new ArrayList<Integer>();
        l.add("12.9");
        System.out.println(l);

        GenericClassB<SolidClass> b = new GenericClassB<SolidClass>();
        List<SolidClass> list = new ArrayList<SolidClass>();
        list.add(new SolidClass());
        b.printClassName(list);
    }
}
