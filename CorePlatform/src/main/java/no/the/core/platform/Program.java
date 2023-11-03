package no.the.core.platform;

import static no.the.core.platform.iostreamsfiles.Main.*;
import static no.the.core.platform.niofiles.Main.nioExemplesZipFiles;

public class Program {


    public static void main(String[] args) {
        //ioExempleStreamsFiles();
        nioExemplesZipFiles();
    }

    private static void ioExempleStreamsFiles() {
        //doTryCatchFinally();
        //doTryWithResources();
        doTryWithResourcesMulti();
        //doCloseThing();
    }
}
