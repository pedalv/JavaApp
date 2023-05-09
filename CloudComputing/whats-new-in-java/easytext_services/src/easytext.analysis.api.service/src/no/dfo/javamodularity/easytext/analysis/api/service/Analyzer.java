package no.dfo.javamodularity.easytext.analysis.api.service;

import java.util.List;

public interface Analyzer {
   
   String getName();
   
   double analyze(List<List<String>> text);

}