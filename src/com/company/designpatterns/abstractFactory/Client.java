package com.company.designpatterns.abstractFactory;

/**
 * Created by princegupta on 30/10/17.
 */
public class Client {
    public static void main(String[] args) {
        WidgetFactory motifFactory = new MotifWidgetFactory();
        motifFactory.createScrollBar().scroll();
        motifFactory.createWindow().windowClick();

        Integer a = 100000;
        Integer b = 100000;

        System.out.print(a == b);
    }
}
