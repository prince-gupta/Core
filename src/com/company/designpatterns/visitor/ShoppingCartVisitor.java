package com.company.designpatterns.visitor;

/**
 * Created by Pgupta on 3/1/2015.
 */
public interface ShoppingCartVisitor {

    int visit(Book book);
    int visit(Fruit fruit);
}