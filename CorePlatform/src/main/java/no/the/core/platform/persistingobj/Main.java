package no.the.core.platform.persistingobj;

import no.the.core.platform.multithreadingconcurrency.concurrency.AccountGroup;
import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;

public class Main {

    public static void main (String ... args){
        Help helper = new Help();

        /*
        BankAccount acct = new BankAccount(500,"1234");
        acct.deposit(270);
        helper.saveAccount(acct, "account.dat");
        */
        //BankAccount ba = helper.loadAccount("account2.dat");

        /*
        BankAccount acct1 = new BankAccount(500,"1234");
        BankAccount acct2 = new BankAccount(750,"5678");
        AccountGroup group = new AccountGroup();
        group.addAccount(acct1);
        group.addAccount(acct2);
        helper.saveGroup(group,"group.dat");
        */
        AccountGroup g = helper.loadGroup("group.dat");
        System.out.println(g.getTotalBalance());

    }
}
