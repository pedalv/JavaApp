package no.the.core.platform.multithreadingconcurrency.concurrency;

import no.the.core.platform.metadata.ProcessedBy;
import no.the.core.platform.multithreadingconcurrency.concurrency.runnable.AccountWorkerRunnable2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@ProcessedBy(AccountWorkerRunnable2.class)
public class BankAccount implements Serializable {

    private static final long serialVersionUID = -6328564483941980673L;

    private String id;
    private int balance;

    private char lastTxType;
    private int lastTxAmount;

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

    public char getLastTxType() {
        return lastTxType;
    }

    public int getLastTxAmount() {
        return lastTxAmount;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit (int amount) {
        balance +=amount;
        lastTxType = 'd';
        lastTxAmount = amount;
        System.out.println("deposit: " + amount + " balance: " + balance);
    }

    public synchronized void withdrawal(int amount){
        balance -= amount;
        lastTxType = 'w';
        lastTxAmount = amount;
        System.out.println("withdrawal: " + amount + " balance: " + balance);
    }

    /*
        synchronized
        - Balance is always increment with the correct order -> 100, 110, 120, 130, ...
        no synchronized
        - Balance could be 100, 120, 110, 130, ...
     */

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }

    private void writeObject(ObjectOutputStream out)
            throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in)
            throws  IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        id = (String) fields.get("id", null);
        balance = fields.get("balance", 0);
        lastTxType = fields.get("lastTxType", 'u');
        lastTxAmount = fields.get("lastTxAmount",-1);
    }
}
