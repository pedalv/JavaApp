package no.the.core.platform.multithreadingconcurrency.notimplements;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Adder {

    private String inFile, outFile;

    public Adder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void doAdd() throws IOException, InterruptedException {

        int total = 0;
        String line = null;

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while((line = reader.readLine()) != null)
                total += line.length();
        }
        Thread.sleep(1000*2);
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))){
            writer.write("Total: " + total);
        }
    }

}
