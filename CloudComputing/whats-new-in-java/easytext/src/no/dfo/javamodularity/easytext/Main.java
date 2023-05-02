package no.dfo.javamodularity.easytext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Example before Java 9
 *
 * Example Application: EasyText, https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests
 * - Analyze text complexity
 * - Read file => output metric
 * - Multiple algorithms, e.g. Flesch-Kincaid, Coleman
 *
 * Start simple:
 * - easytext
 * Later:
 * - Separate analysis from main app
 * - Multiple front-ends
 * - Multiple analyses
 *
 *
 * - for Linux
 * javac --module-source-path src -d out $(find . name '*.java')
 *
 *
 * - Java 8 in terminal
 * Step 1:
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java\easytext> javac --module-source-path src -d out $(find . name '*.java')
 * FIND: Parameter format not correct
 * error: no source files
 *
 * Step 2:
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java> java --module-path out -m .\out\production\easytext\no\dfo\javamodularity\easytext\Main.class /<textinput.txt>
 * Unrecognized option: --module-path
 * Error: Could not create the Java Virtual Machine.
 * Error: A fatal exception has occurred. Program will exit.
 *
 *
 * Run for IDE *****************
 * Step 1:
 * C:\Java\jdk-17.0.6+10\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2022.3.3\lib\idea_rt.jar=49299:C:\Program Files\JetBrains\IntelliJ IDEA 2022.3.3\bin" -Dfile.encoding=UTF-8 -classpath C:\workspace2\JavaApp\CloudComputing\whats-new-in-java\out\production\easytext no.dfo.javamodularity.easytext.Main C:\workspace2\JavaApp\CloudComputing\whats-new-in-java\easytext\src\no\dfo\javamodularity\easytext\Main.java
 * Hello world!
 * Reading C:\workspace2\JavaApp\CloudComputing\whats-new-in-java\easytext\src\no\dfo\javamodularity\easytext\Main.java
 * Flesch-Kincaid: 41.69812149763109
 *
 * Step 2:
 * Java to Java 17 for example
 *
 */
public class Main {
    public static void main(String... args) throws IOException {
        System.out.println("Hello world!");

        if (args.length == 0) {
            System.out.println("Welcome to EasyText. Please provide a filename as input argument");
            return;
        }

        Path path = Paths.get(args[0]);
        System.out.println("Reading " + path);
        String text = new String(Files.readAllBytes(path), Charset.forName("UTF-8"));

        List<List<String>> sentences = toSentences(text);

        System.out.println("Flesch-Kincaid: " + analyze(sentences));
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

    public static double analyze(List<List<String>> sentences) {
        float totalsentences = sentences.size();
        float totalwords = sentences.stream().mapToInt(sentence -> sentence.size()).sum();
        float totalsyllables = sentences.stream()
                .flatMapToInt(sentence ->
                        sentence.stream().mapToInt(word -> countSyllables(word)))
                .sum();
        return 206.835 - 1.015 * (totalwords / totalsentences) - 84.6 * (totalsyllables / totalwords);
    }

    public static int countSyllables(String word) {
        int syllables = 0;
        boolean prevNonVowel = false;
        for(int i = 0; i < word.length(); i++) {
            boolean isVowel = isVowel(word.toLowerCase().charAt(i));
            if(prevNonVowel && isVowel && i != word.length() - 1) {
                syllables++;
            }
            prevNonVowel = !isVowel;
        }
        syllables = syllables == 0 ? 1 : syllables;
        return syllables;
    }

    private static boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }

}