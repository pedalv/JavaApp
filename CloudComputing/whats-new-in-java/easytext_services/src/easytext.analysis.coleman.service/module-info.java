module easytext.analysis.coleman.service {

    requires easytext.analysis.api.service;

    provides no.dfo.javamodularity.easytext.analysis.api.service.Analyzer
            with no.dfo.javamodularity.easytext.analysis.coleman.service.ColemanAnalyzer;

}