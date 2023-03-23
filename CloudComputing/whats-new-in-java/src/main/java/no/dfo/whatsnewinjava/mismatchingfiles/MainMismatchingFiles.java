package no.dfo.whatsnewinjava.mismatchingfiles;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class MainMismatchingFiles {

    public static void main(String ...args) {
        String file1 = "README.md";
        String file2 = "README.md";
        try {
            String path = "C:\\workspace2\\JavaApp\\CloudComputing\\whats-new-in-java\\";
            long res = Files.mismatch(Path.of(path + file1), Path.of(path + file2));
            log.info(String.valueOf(res)); //-1 or first mismatching byte

            res = Files.mismatch(Path.of(file1), Path.of(file2));
            log.info(String.valueOf(res)); //-1 or first mismatching byte

            res = Files.mismatch(Path.of(file1), Path.of(file1));
            log.info(String.valueOf(res)); //-1 or first mismatching byte

            //Finds and returns the position of the first mismatched byte in the content of two files,
            // or -1L if there is no mismatch.
            // The position will be in the inclusive range of 0L up to the size (in bytes) of the smaller file

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
