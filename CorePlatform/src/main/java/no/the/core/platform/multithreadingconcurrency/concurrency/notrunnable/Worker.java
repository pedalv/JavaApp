package no.the.core.platform.multithreadingconcurrency.concurrency.notrunnable;

import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;

public class Worker{

    private BankAccount account;

    public Worker(BankAccount account) {
        this.account = account;
    }

    public void useaccount(BankAccount account) {
        int startBalance = account.getBalance();
        account.deposit(10);
        int endBalance = account.getBalance();
        System.out.println("End Balance: " + endBalance + " StartBalance: " + startBalance);
    }

}
