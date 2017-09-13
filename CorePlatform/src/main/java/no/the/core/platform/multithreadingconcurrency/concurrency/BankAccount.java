package no.the.core.platform.multithreadingconcurrency.concurrency;

public class BankAccount {

    private final String id;
    private int balance;

    public BankAccount(String id) {
        this.id = id;
    }

    public BankAccount(int balance, String id) {
        this.balance = balance;
        this.id = id;
    }

    public BankAccount() {
        this.id = "";
    }

    public String getId() {
        return id;
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
