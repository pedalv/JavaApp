package no.the.core.platform.multithreadingconcurrency.concurrency;

public final  class HighVolumeAccount extends BankAccount implements Runnable {


    public HighVolumeAccount(String id) {
        super(id);
    }

    public HighVolumeAccount(int balance, String id) {
        super(balance, id);
    }


    private int[] readDailyDeposits() {
        return new int[]{1, 2, 3};
    }
    private int[] readDailyWithdrawals() {
        return new int[]{4, 5, 6};
    }

    @Override
    public void run() {

    for(int depositAmt: readDailyDeposits())
        deposit(depositAmt);

    for(int withdrawals: readDailyWithdrawals())
        withdrawal(withdrawals);
    }
}
