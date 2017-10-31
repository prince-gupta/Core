package com.company.designpatterns.proxy;

/**
 * Created by Pgupta on 3/1/2015.
 */
public class ProxyCommandExecutor implements CommandExecutor {
    private boolean isAdmin;
    private CommandExecutor executor;

    public ProxyCommandExecutor(String user, String pswd) {
        if ("prince".equalsIgnoreCase(user) && "hello".equals(pswd))
            isAdmin = true;
        executor = new CommnadExecutorImpl();
    }

    @Override
    public void execute(String cmd) throws Exception {
        if (isAdmin) {
            executor.execute(cmd);
        } else if (cmd.trim().startsWith("rm")) {
            throw new Exception("You are not authorized to execute this command");
        } else
            executor.execute(cmd);
    }
}