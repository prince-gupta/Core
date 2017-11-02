package com.company.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by princegupta on 01/11/17.
 */
public class InvocationHandlerImpl implements InvocationHandler {
    Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        System.out.println("Total Time Taken : " + (System.currentTimeMillis() - startTime));
        return result;
    }
}
