package com.company.sync;

public class BankThread extends Thread {
    private Bank bankWork;
    private int transaction;
    private long sleep;

    public BankThread(Bank bankWork, int transaction, long sleep) {
        this.bankWork = bankWork;
        this.transaction = transaction;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        bankWork.calc(transaction, sleep);
    }
}