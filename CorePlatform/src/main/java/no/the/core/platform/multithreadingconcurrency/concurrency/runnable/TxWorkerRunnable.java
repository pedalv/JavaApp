package no.the.core.platform.multithreadingconcurrency.concurrency.runnable;

import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;

public class TxWorkerRunnable implements Runnable {

    protected BankAccount account;
    protected char txType; // 'w' -> withdrawal, 'd' -> deposit
    protected int amt;

    public TxWorkerRunnable(BankAccount account, char txType, int amt) {
        this.account = account;
        this.txType = txType;
        this.amt = amt;
    }

    @Override
    public void run() {
        if(txType == 'w')
            account.withdrawal(amt);
        else if (txType == 'd')
            account.deposit(amt);
    }
}
