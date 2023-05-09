module easytext.gui.service {
    // JavaFX needs to instantiate our Main Application class
    exports no.dfo.javamodularity.easytext.gui.service to javafx.graphics;

    requires javafx.graphics;
    requires javafx.controls;
    requires easytext.analysis.api.service;

    uses no.dfo.javamodularity.easytext.analysis.api.service.Analyzer;
}