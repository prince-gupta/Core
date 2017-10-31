package com.company.designpatterns.abstractFactory.widgets.impls;

import com.company.designpatterns.abstractFactory.widgets.ScrollBar;

/**
 * Created by princegupta on 30/10/17.
 */
public class PMScrollBar implements ScrollBar {
    @Override
    public void scroll() {
        System.out.println("PM Scroll Performed");
    }
}
