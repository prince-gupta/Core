package com.company.generics;

import java.util.List;

/**
 * Created by Pgupta on 23-03-2016.
 */
public class GenericClassB<T> {

    public void printClassName(List<T> list){
        for(T obj : list){
            System.out.println(obj.getClass().getCanonicalName());
        }
    }
}
