package no.dfo.javamodularity.easytext.analysis.kincaid.service;

import no.dfo.javamodularity.easytext.analysis.api.service.Analyzer;
import no.dfo.javamodularity.easytext.analysis.kincaid.service.internal.SyllableCounter;

import java.util.List;

/**
 * https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests
 */
public class KincaidAnalyzer implements Analyzer {

   public String getName() {
      return "Flesch-Kincaid";
   }

   public double analyze(List<List<String>> sentences) {
      float totalsentences = sentences.size();
      float totalwords = sentences.stream().mapToInt(sentence -> sentence.size()).sum();
      float totalsyllables = sentences.stream()
         .flatMapToInt(sentence ->
            sentence.stream().mapToInt(word -> SyllableCounter.countSyllables(word)))
         .sum();
      return 206.835 - 1.015 * (totalwords / totalsentences) - 84.6 * (totalsyllables / totalwords);
   }

}
