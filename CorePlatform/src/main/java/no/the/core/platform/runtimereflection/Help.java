package no.the.core.platform.runtimereflection;

import no.the.core.platform.metadata.ProcessedBy;
import no.the.core.platform.metadata.WorkHandler;
import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;
import no.the.core.platform.multithreadingconcurrency.concurrency.runnable.TaskWorker;

import java.lang.reflect.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Help {

    //ONLY 2 threads can be create without concluded
    private static ExecutorService pool = Executors.newFixedThreadPool(2);


    public void doWork(Object obj) {
        Class<?> c = obj.getClass();
        showName(c);
    }

    private void showName(Class<?> theClass) {
        System.out.println(theClass.getSimpleName());
    }


    public void classInfo(Object obj) {

        Class<?> theClass = obj.getClass();
        System.out.println(theClass.getSimpleName());

        Class<?> superClass = theClass.getSuperclass();
        System.out.println(superClass.getSimpleName());

        Class<?>[] interfaces = theClass.getInterfaces();
        for (Class<?> isinterface : interfaces)
            System.out.println(isinterface.getSimpleName() + " " + isinterface.isInterface());

    }

    public void typeModifiers(Object obj) {
        Class<?> theClass = obj.getClass();
        int modifiers = theClass.getModifiers();

        if ((modifiers & Modifier.FINAL) > 0)
            System.out.println("bitwise check - final");

        if (Modifier.isFinal(modifiers))
            System.out.println("method check - final");

        if (Modifier.isPrivate(modifiers))
            System.out.println("method check - private");

        if (Modifier.isProtected(modifiers))
            System.out.println("method check - protected");

        if (Modifier.isPublic(modifiers))
            System.out.println("method check - public");
    }


    void fieldInfo(Object obj) {
        Class<?> theClass = obj.getClass();

        Field[] fields = theClass.getFields();
        displayFields(fields);

        Field[] declaredFields = theClass.getDeclaredFields();
        displayFields(declaredFields);

    }

    void displayFields(Field[] fields) {
        for(Field f:fields)
            System.out.println(f.getName() + " : " + f.getType());
    }

    void methodInfo(Object obj) {
        Class<?> theClass = obj.getClass();

        Method[] methods = theClass.getMethods();
        displayMethods(methods);

        Method[] declMethods = theClass.getDeclaredMethods();
        displayMethods(methods);
    }

    void methodInfo2(Object obj) {
        Class<?> theClass = obj.getClass();

        Method[] methods = theClass.getMethods();
        displayMethods2(methods);

    }

    private void displayMethods2(Method[] methods) {
        for(Method m:methods){
            if(m.getDeclaringClass() != Object.class)
                System.out.println(m.getName());
        }
    }

    private void displayMethods(Method[] methods) {
        for(Method m:methods)
            System.out.println(m.getName());
    }


    public void callGetId(Object obj) {

        try {
            Class<?> theClass = obj.getClass();
            Method m  = theClass.getMethod("getId");
            Object result = m.invoke(obj);
            System.out.println("Result: " + result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public void CallDeposit(Object obj, int amt) {

        try {
            Class<?> theClass = obj.getClass();
            Method m  = theClass.getMethod("deposit", int.class);
            m.invoke(obj, amt);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // one way  to achieve this type of results - exception
    public void startWork(String workerTypeName, Object workerTarget)  {
        try {
            //get type information for worker
            Class<?> workerType = Class.forName(workerTypeName);
            //get instance constructor of that worker
            Class<?> targetType = workerType.getClass();
            Constructor c = workerType.getConstructor(targetType); //problems here
            Object worker = c.newInstance(workerTarget);
            //get information of the method and call the method
            Method doWork = workerType.getMethod("doWork");
            doWork.invoke(worker);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // other way more easy to achieve this type of results - OKAY
    public void startWork2(String workerTypeName, Object workerTarget) throws Exception {
        try {
            //get type information for THE worker
            Class<?> workerType = Class.forName(workerTypeName);
            TaskWorker worker = (TaskWorker)workerType.newInstance();
            worker.setTarget(workerTarget);

            // anotation
            WorkHandler wh = workerType.getAnnotation(WorkHandler.class);
            if(wh == null)
                throw new IllegalArgumentException("feil call WorkHandler annotation");

            if(wh.useThreadPool()) {
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        worker.doWork();
                    }
                });
            } else
                worker.doWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void startWorkContained(Object workerTarget) {
        try {
            Class<?> targetType = workerTarget.getClass();
            ProcessedBy pb = targetType.getAnnotation(ProcessedBy.class);
            Class<?> workerType = pb.value();
            TaskWorker worker = (TaskWorker)workerType.newInstance();
            worker.setTarget(workerTarget);

            // anotation
            WorkHandler wh = workerType.getAnnotation(WorkHandler.class);
            if(wh == null)
                throw new IllegalArgumentException("feil call WorkHandler annotation");

            if(wh.useThreadPool()) {
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        worker.doWork();
                    }
                });
            } else
                worker.doWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}