package com.company.designpatterns.proxy;

/**
 * Created by Pgupta on 3/1/2015.
 */
public class ProxyCommandTest {
    public static void main(String[] args) {
        CommandExecutor executor = new ProxyCommandExecutor("prince","he");
        try {
            executor.execute("dir");
            executor.execute("rm abc.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
