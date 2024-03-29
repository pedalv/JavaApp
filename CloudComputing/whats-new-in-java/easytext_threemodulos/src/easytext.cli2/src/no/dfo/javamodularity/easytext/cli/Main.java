package no.dfo.javamodularity.easytext.cli;

import no.dfo.javamodularity.easytext.analysis.FleschKincaid;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * javac --module-source-path src -d out $(find . name '*.java')
 * java -mp out -easytext.cli/no.dfo.javamodularity.easytext.cli.Main
 *
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

        System.out.println("Flesch-Kincaid: " + new FleschKincaid().analyze(sentences));

    }


    public static List<List<String>> toSentences(String text) {
        String removedBreaks = text.replaceAll("\\r?\\n", " ");
        ArrayList<List<String>> sentences = new ArrayList<>();
        for(String rawSentence: removedBreaks.split("[\\.\\?\\!]")) {
            List<String> words = toWords(rawSentence);
            if(words.size() > 0) {
                sentences.add(words);
            }
        }

        return sentences;
    }

    public static List<String> toWords(String sentence) {
        String[] rawWords = sentence.split("\\s+");
        List<String> words = new ArrayList<>();
        for(String rawWord: rawWords) {
            String word = rawWord.replaceAll("\\W", "");
            if(word.length() > 0) {
                words.add(word);
            }
        }

        return words;
    }

}
