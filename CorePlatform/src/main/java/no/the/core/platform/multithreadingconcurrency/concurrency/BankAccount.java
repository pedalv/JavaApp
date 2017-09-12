package no.the.core.platform.multithreadingconcurrency.concurrency;

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit (int amount) {
        balance +=amount;
        System.out.println("deposit: " + amount + " balance: " + balance);
    }

    public synchronized void withdrawal(int amount){
        balance -= amount;
        System.out.println("withdrawal: " + amount + " balance: " + balance);
    }

    /*
        synchronized
        - Balance is always increment with the correct order -> 100, 110, 120, 130, ...
        no synchronized
        - Balance could be 100, 120, 110, 130, ...
     */

}
