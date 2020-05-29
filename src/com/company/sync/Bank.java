package com.company.sync;

public class Bank {
    private int to;
    private int from = 220;

    public synchronized void calc(int transaction, long timeout) {
        System.out.println("Start of transaction: to = " + to + ", from: " + from + ", thread: " + Thread.currentThread().getName());
        from -= transaction;
        try {
            Thread.sleep(timeout);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        to += transaction;
        System.out.println("End of transaction: to = " + to + ", from: " + from + ", thread: " + Thread.currentThread().getName());
    }
}