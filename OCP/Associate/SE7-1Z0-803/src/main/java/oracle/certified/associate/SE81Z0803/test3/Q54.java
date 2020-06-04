package oracle.certified.associate.SE81Z0803.test3;

/**
 * Created by pedro alves on 01/03/15.
 */
public class Q54 {

    public static void main(String ... args){

        int i = 10;

        new TestClass().getWorkerByClass(i).perform_work();

        new TestClass().getWorkerByAnonymousClass(i).perform_work();

        /*
        A nested static class can be instantiated in any other
        class by doing:
         */
        new TestClass.MyWorker().perform_work();




    }


}

interface Worker {
    void perform_work();
}


class TestClass{

    static final int j = 11;

    /*
    There is no instance of TestClass associated with the MyWorker
    class. Inside TestClass I can instantiate it directly:
     */
    Worker worker = new MyWorker();


    static class MyWorker implements Worker{

        @Override
        public void perform_work() {
            System.out.println(j);
        }


        Worker worker = new MyWorker();

    }






    Worker getWorkerByAnonymousClass(final int i){

        /*
        I am not instantiating an interface, i am instantiating an
        anonymous class that implements the interface Worker.
        */
        return new Worker() {
            @Override
            public void perform_work() {
                System.out.println(i);
            }
        };

    }


    Worker getWorkerByClass(final int i){

        class MyWorker implements Worker{
            @Override
            public void perform_work() {
                System.out.println(i);
            }
        }

        return new MyWorker();
    }


}


/*
A neste class - is any class whoese declaration accurs within
the body of another class or interface

A top level class - is a class that is not a nested class

An inner class is a nested class that is not explicitly
or implicitly declared static.
A class defined inside an interface is implicitly static.
 */