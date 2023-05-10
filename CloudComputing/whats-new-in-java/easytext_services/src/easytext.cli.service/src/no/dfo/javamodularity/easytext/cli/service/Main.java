package no.dfo.javamodularity.easytext.cli.service;

import no.dfo.javamodularity.easytext.analysis.api.service.Analyzer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ServiceLoader;

import static no.dfo.javamodularity.easytext.analysis.api.service.Preprocessing.toSentences;

/**
 *
 *
 * ..\..\..\..\Java\jdk-20.0.1\bin\javac --module-source-path src -d out $(find . name '*.java')
 * ..\..\..\..\Java\jdk-20.0.1\bin\java -mp out -easytext.cli/no.dfo.javamodularity.easytext.cli.Main ../testinput.txt
 * ..\..\..\..\Java\jdk-20.0.1\bin\java -module-path out -m easytext.cli.service/no.dfo.javamodularity.easytext.cli.service.Main ../testinput.txt
 *
 *
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java\easytext.cli.service>
 * ..\..\..\..\..\Java\jdk-20.0.1\bin\javac --module-source-path src -d out ..\testinput.txt
 * error: invalid flag: ..\testinput.txt
 * Usage: javac <options> <source files>
 * use --help for a list of possible options
 *
 * file: C:/workspace2/JavaApp/CloudComputing/whats-new-in-java/testinput.txt
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        if (args.length == 0) {
            System.out.println("Welcome to EasyText. Please provide a filename as input argument");
            return;
        }

        Path path = Paths.get(args[0]);
        System.out.println("Reading " + path);
        String text = new String(Files.readAllBytes(path), Charset.forName("UTF-8"));

        List<List<String>> sentences = toSentences(text);

        //changes here
        Iterable<Analyzer> analyzers = ServiceLoader.load(Analyzer.class);
        for(Analyzer analyzer: analyzers) {
            System.out.println(analyzer.getName() + ": " + analyzer.analyze(sentences));
        }

    }

}
