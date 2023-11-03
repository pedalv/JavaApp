package no.the.core.platform.metadata;

public class Doer {

    @Deprecated
    void doItThisWay() {}
    void doItThisNewWay() {}
}

class MyWorker {

    @SuppressWarnings("deprecation")
    void doSomeWork(){
        Doer d = new Doer();
        d.doItThisWay();
    }

    @SuppressWarnings("deprecation")
    void doDoubleWork(){
        Doer d1 = new Doer();
        Doer d2 = new Doer();
        d1.doItThisWay();
        d2.doItThisWay();
    }

    void doGoodWork(){
        Doer d = new Doer();
        d.doItThisNewWay();
    }

    void dobadWork(){
        Doer d = new Doer();
        d.doItThisWay();
    }
}
