package no.dfo.whatsnewinjava.textblocks;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

/**
 * java --enable-preview --source 12 TextBlockDemo.java
 *
 * text.translateEscapes()
 *
 */
public class TextBlockDemo {

    Consumer<String> println = System.out::println;

    public static void main(String ...args) {
        String text = """
                This is "definitely"
                a multi-line
                string""";
        System.out.println(text);
        showWhitespace(text);
    }

    private static void showWhitespace(String string) {
        System.out.println(string.replaceAll(" ", ".").replaceAll("\n", "\\\\n\n"));
    }

}
