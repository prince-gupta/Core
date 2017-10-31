package com.company.designpatterns.abstractFactory.widgets.impls;

import com.company.designpatterns.abstractFactory.widgets.Window;

/**
 * Created by princegupta on 30/10/17.
 */
public class MotifWindow implements Window {
    @Override
    public void windowClick() {
        System.out.println("Motif Window Clicked");
    }
}
