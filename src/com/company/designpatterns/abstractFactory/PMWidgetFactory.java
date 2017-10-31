package com.company.designpatterns.abstractFactory;

import com.company.designpatterns.abstractFactory.widgets.ScrollBar;
import com.company.designpatterns.abstractFactory.widgets.Window;
import com.company.designpatterns.abstractFactory.widgets.impls.PMScrollBar;
import com.company.designpatterns.abstractFactory.widgets.impls.PMWindow;

/**
 * Created by princegupta on 30/10/17.
 */
public class PMWidgetFactory implements WidgetFactory {
    @Override
    public ScrollBar createScrollBar() {
        return new PMScrollBar();
    }

    @Override
    public Window createWindow() {
        return new PMWindow();
    }
}
