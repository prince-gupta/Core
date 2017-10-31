package com.company.designpatterns.abstractFactory;

import com.company.designpatterns.abstractFactory.widgets.ScrollBar;
import com.company.designpatterns.abstractFactory.widgets.Window;
import com.company.designpatterns.abstractFactory.widgets.impls.MotifScrollBar;
import com.company.designpatterns.abstractFactory.widgets.impls.MotifWindow;

/**
 * Created by princegupta on 30/10/17.
 */
public class MotifWidgetFactory implements WidgetFactory {
    @Override
    public ScrollBar createScrollBar() {
        return new MotifScrollBar();
    }

    @Override
    public Window createWindow() {
        return new MotifWindow();
    }
}
