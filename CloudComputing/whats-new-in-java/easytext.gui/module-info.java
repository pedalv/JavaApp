module easytext.gui {
    // JavaFX needs to instantiate our Main Application class
    exports no.dfo.javamodularity.easytext.gui to javafx.graphics;

    //requires javafx.graphics;
    requires javafx.controls;
    requires easytext.analysis;
}
