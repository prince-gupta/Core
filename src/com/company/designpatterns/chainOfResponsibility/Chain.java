package com.company.designpatterns.chainOfResponsibility;

/**
 * Created by Pgupta on 9/11/2015.
 */
public interface Chain {
    public void setNextChain(Chain chain);
    public void calculate(Numbers numbers);
}
