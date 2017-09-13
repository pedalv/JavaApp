package no.the.core.platform.multithreadingconcurrency.concurrency.runnable;

public interface TaskWorker {
    void setTarget(Object targer);
    void doWork();
}
