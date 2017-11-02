package com.company.proxies;

/**
 * Created by princegupta on 01/11/17.
 */
public class BasicFuncImpl implements BasicFunc {
    @Override
    public void waitAndPrint() throws InterruptedException {
        System.out.println("Executing Method");
        Thread.sleep(2000);
        System.out.println("Done Executing Method");

    }
}
