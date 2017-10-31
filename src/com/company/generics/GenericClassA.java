package com.company.generics;

/**
 * Created by Pgupta on 8/9/2014.
 */
public class GenericClassA<E,T> {
    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    private E e;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        if(t == null)
             throw new ErrorClass("Null Object");
        this.t = t;

    }

    private T t;
}
