package no.dfo.whatsnewinjava.textblocks;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MainCharSet {

    public static void main(String... args) throws IOException {

        Charset charset = Charset.forName("windows-1252"); //UnsupportedCharsetException

        //Java 18
        //Charset charset2 = Charset.forName("windows-1252", StandardCharsets.UTF_8);

        FileWriter writer = new FileWriter("HELP.md", charset);


    }

}
