package com.company.designpatterns.abstractFactory;

import com.company.designpatterns.abstractFactory.widgets.ScrollBar;
import com.company.designpatterns.abstractFactory.widgets.Window;

/**
 * Created by princegupta on 30/10/17.
 */
public interface WidgetFactory {
    ScrollBar createScrollBar();
    Window createWindow();
}
