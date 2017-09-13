package no.the.core.platform.multithreadingconcurrency.concurrency.runnable;

import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;
import no.the.core.platform.multithreadingconcurrency.concurrency.HighVolumeAccount;

public class AccountWorkerRunnable implements Runnable {


    BankAccount ba; //Target
    HighVolumeAccount hva;

    /*public AccountWorkerRunnable() {
    }*/

    public AccountWorkerRunnable(BankAccount ba) {
        this.ba = ba;
    }

    public AccountWorkerRunnable(HighVolumeAccount hva) {
        this.hva = hva;
    }

    /*public AccountWorkerRunnable(BankAccount ba, HighVolumeAccount hva) {
        this.ba = ba;
        this.hva = hva;
    }*/

    public void doWork(){
        Thread t = new Thread(hva != null ? hva : this);
        t.start();
    }

    @Override
    public void run() {
        char txType = 'w'; //red tx type
        int amt = 500; // read tx amount

        if(txType == 'w')
            ba.withdrawal(amt);
        else if (txType == 'd')
            ba.deposit(amt);

    }

}
