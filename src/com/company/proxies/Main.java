package com.company.proxies;

import java.lang.reflect.Proxy;

/**
 * Created by princegupta on 01/11/17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BasicFuncImpl basicFuncImpl = new BasicFuncImpl();

        BasicFunc basicFunc = (BasicFunc) Proxy.newProxyInstance(Main.class.getClassLoader(),basicFuncImpl.getClass().getInterfaces(),
                new InvocationHandlerImpl(basicFuncImpl));

        basicFunc.waitAndPrint();
    }
}
