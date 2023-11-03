package no.the.core.platform.multithreadingconcurrency.concurrency.runnable;

import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;

public class WorkerRunnable implements Runnable{

    private BankAccount account;
    private int work;

    public WorkerRunnable(BankAccount account, int work) {
        this.account = account;
        this.work = work;
    }

    public void useaccount() {
        for(int i = 0; i < 10; i++) {

            int startBalance = account.getBalance();

            /*
            - other way to synchronized statement block
            synchronized (account){
                account.deposit(10);
            }
            */
            account.deposit(10);
            int endBalance = account.getBalance();
            System.out.println("End Balance: " + endBalance + " StartBalance: " + startBalance + " work: " + work);

        }
    }

    public BankAccount getAccount() {
        return account;
    }

    @Override
    public void run() {
        useaccount();
    }
}
