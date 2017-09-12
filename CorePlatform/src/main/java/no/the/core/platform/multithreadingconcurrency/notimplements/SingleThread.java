package no.the.core.platform.multithreadingconcurrency.notimplements;

import java.io.IOException;

public class SingleThread {

    static String[] inFiles = {"inFile1.txt","inFile2.txt","inFile3.txt","inFile4.txt","inFile5.txt", "inFile6.txt" };
    static String[] outFiles = {"outFile1.txt","outFile2.txt","outFile3.txt",
            "outFile4.txt","outFile5.txt", "outFile6.txt" };

    public static void runInsideMain() {


        try {
            for(int i = 0; i <= inFiles.length - 1; i++) {

                dothings(i); //36 sec
            }
        } catch (InterruptedException | IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }

    private static void dothings(int i) throws InterruptedException, IOException {
        Adder adder = new Adder(inFiles[i], outFiles[i]);
        Thread.sleep(1000*2);
        adder.doAdd();
        Thread.sleep(1000*2);
        System.out.println("called Adder(inFiles["+i+"], outFiles["+i+"]");
    }
}
