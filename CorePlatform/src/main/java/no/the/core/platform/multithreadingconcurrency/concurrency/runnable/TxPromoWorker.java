package no.the.core.platform.multithreadingconcurrency.concurrency.runnable;

import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;

public class TxPromoWorker extends TxWorkerRunnable {

    public TxPromoWorker(BankAccount account, char txType, int amt) {
        super(account, txType, amt);
    }

    @Override
    public void run() {
        //problemPromo();
        fixPromo();
    }

    public void fixPromo() {

        if(txType == 'w')
            account.withdrawal(amt);
        else if (txType == 'd') {
            //problem is fix now
            synchronized (account) {
                account.deposit(amt);
                if(account.getBalance() > 500) {
                    int bonus = (int)((account.getBalance() - 500) * 0.1);
                    account.deposit(bonus);
                }
            }

        }

    }

    public void problemPromo() {
        if(txType == 'w')
            account.withdrawal(amt);
        else if (txType == 'd') {
            account.deposit(amt);
            if(account.getBalance() > 500) {
                int bonus = (int)((account.getBalance() - 500) * 0.1);
                /*
                problem:
                - lock could not be available now,
                - need wait for a 'd' or a 'w'
                - if 'w' change balance lower then 500 it mean bonus will be negative
                 */
                account.deposit(bonus);
            }
        }
    }
}
