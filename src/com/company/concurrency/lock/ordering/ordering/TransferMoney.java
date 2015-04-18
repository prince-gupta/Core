package com.company.concurrency.lock.ordering.ordering;

/**
 * Created by Pgupta on 2/8/2015.
 */
public class TransferMoney {
    private static final Object tieLock = new Object();

    public void transferMoney(final Account fromAccount, final Account toAccount, final float amount) throws Exception {
        class Helper {
            public void transfer() throws Exception {
                if (fromAccount.getBalance() < amount) {
                    throw new Exception("Insufficient Balance");
                }
                else{
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }

        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);

        if(fromHash < toHash){
            synchronized (fromAccount){
                synchronized (toAccount){
                    new Helper().transfer();
                }
            }
        }
        else if(fromHash > toHash){
            synchronized (toAccount){
                synchronized (fromAccount){
                    new Helper().transfer();
                }
            }
        }
        else{
            synchronized (tieLock){
                synchronized (fromAccount){
                    synchronized (toAccount){
                        new Helper().transfer();
                    }
                }
            }
        }
    }
}
