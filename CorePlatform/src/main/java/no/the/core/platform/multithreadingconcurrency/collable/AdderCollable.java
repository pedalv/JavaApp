package no.the.core.platform.multithreadingconcurrency.collable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class AdderCollable implements Callable<Integer> {

    private String inFile, outFile;

    public AdderCollable(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public int doAdd() throws IOException, InterruptedException {

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

        return total;
    }

    @Override
    public Integer call() throws Exception {
        try {
            return doAdd();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
