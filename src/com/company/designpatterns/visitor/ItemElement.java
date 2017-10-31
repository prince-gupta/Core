package com.company.designpatterns.visitor;

/**
 * Created by Pgupta on 3/1/2015.
 */
public interface ItemElement {
    public int accept(ShoppingCartVisitor visitor);
}
