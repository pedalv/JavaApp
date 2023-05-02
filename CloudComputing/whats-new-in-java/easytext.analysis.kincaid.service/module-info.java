module easytext.analysis.kincaid.service {

    requires easytext.analysis.api.service;

    provides no.dfo.javamodularity.easytext.analysis.api.service.Analyzer
            with no.dfo.javamodularity.easytext.analysis.kincaid.service.KincaidAnalyzer;

}