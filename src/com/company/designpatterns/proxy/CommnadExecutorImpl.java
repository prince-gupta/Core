package com.company.designpatterns.proxy;

/**
 * Created by Pgupta on 3/1/2015.
 */
public class CommnadExecutorImpl implements CommandExecutor {
    @Override
    public void execute(String command) throws Exception{
        Runtime.getRuntime().exec(command);
        System.out.println("'"+command+"' executed !" );
    }
}
