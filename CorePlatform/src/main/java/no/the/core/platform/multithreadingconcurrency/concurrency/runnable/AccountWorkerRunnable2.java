package no.the.core.platform.multithreadingconcurrency.concurrency.runnable;

import no.the.core.platform.metadata.WorkHandler;
import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;
import no.the.core.platform.multithreadingconcurrency.concurrency.HighVolumeAccount;

@WorkHandler(useThreadPool = false)
public class AccountWorkerRunnable2 implements Runnable, TaskWorker {

    BankAccount ba; //Target

    @Override
    public void run() {
        char txType = 'w'; //red tx type
        int amt = 500; // read tx amount

        if(txType == 'w')
            ba.withdrawal(amt);
        else if (txType == 'd')
            ba.deposit(amt);

    }

    @Override
    public void setTarget(Object target) {
        if(BankAccount.class.isInstance(target)){
            ba = (BankAccount)target;
        } else {
            throw new IllegalArgumentException("feil call setTarget");
        }
    }

    @Override
    public void doWork() {
        Thread t = new Thread(
          HighVolumeAccount.class.isInstance(ba) ?
                  (HighVolumeAccount)ba : this
        );
        t.start();
    }


}
