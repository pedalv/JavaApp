package no.dfo.javamodularity.easytext.analysis;

import java.util.List;

import static no.dfo.javamodularity.easytext.analysis.internal.SyllableCounter.countSyllables;

/**
 * https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests
 */
public class FleschKincaid {

    public double analyze(List<List<String>> sentences) {
        float totalsentences = sentences.size();
        float totalwords = sentences.stream().mapToInt(sentence -> sentence.size()).sum();
        float totalsyllables = sentences.stream()
                .flatMapToInt(sentence ->
                        sentence.stream().mapToInt(word -> countSyllables(word)))
                .sum();
        return 206.835 - 1.015 * (totalwords / totalsentences) - 84.6 * (totalsyllables / totalwords);
    }


}
