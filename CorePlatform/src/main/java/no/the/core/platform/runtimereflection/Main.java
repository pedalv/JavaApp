package no.the.core.platform.runtimereflection;

import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;
import no.the.core.platform.multithreadingconcurrency.concurrency.HighVolumeAccount;

public class Main {

    public static void main(String ... args) {
        Help help = new Help();

        BankAccount acct = new BankAccount(100, "123");
        //help.doWork(acct);
        //help.fieldInfo(acct);

        try {
            Class<?> c = Class.forName("no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount");
            // Class<? extends Object> c = Class.forName("no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount");
            //help.doWork(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> c2 = BankAccount.class;
        //help.doWork(c2);

        Class<BankAccount> c3 = BankAccount.class;
        //help.doWork(c3);


        HighVolumeAccount hightvm = new HighVolumeAccount("123");
        //help.classInfo(hightvm);
        //help.typeModifiers(hightvm);
        //help.fieldInfo(hightvm);
        //help.methodInfo(hightvm);
        //help.methodInfo2(hightvm);

        BankAccount acct1 = new BankAccount("1234");
        //help.callGetId(acct1);

        BankAccount acct2 = new BankAccount(500, "1234");
        //help.CallDeposit(acct2, 50);
        //System.out.println("Balance: " + acct2.getBalance());


        BankAccount acct3 = new BankAccount();
        /*
        // one way  to achieve this type of results - exception
        help.startWork(
                "no.the.core.platform.multithreadingconcurrency.concurrency.runnable.AccountWorkerRunnable",
                acct3);
         */

        BankAccount acct4 = new BankAccount();
        /*
        // other way more easy to achieve this type of results - OKAY
        try {
            help.startWork2(
                    "no.the.core.platform.multithreadingconcurrency.concurrency.runnable.AccountWorkerRunnable2",
                    acct4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        */

        BankAccount acct5 = new BankAccount();
        help.startWorkContained(acct5);





    }

}
