package no.cfs.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by p on 10/11/2016.
 */
public class FileWordData {

    static public List<String> ReadFile(String fileName) {

        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            list = stream
                    .filter(line -> !line.isEmpty())
                    .map(String::trim)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        //list.forEach(System.out::println);

        return list;
    }

}

