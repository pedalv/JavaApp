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
        textTranslateEscapes();
    }

    private static void showWhitespace(String string) {
        System.out.println(string.replaceAll(" ", ".").replaceAll("\n", "\\\\n\n"));
    }

    private static void textTranslateEscapes() {
        //String text = Files.readString(Path.of("\"Hello\tWorld\"\n"));

        String text = "\"Hello\tWorld\"\n";
        System.out.println(text);
        //****IMPORTANT****
        System.out.println(text.translateEscapes());

        //Old
        System.out.println(String.format("""
               <html>
                <head><head>
                <body>%s</body>
               </html>
               """, "HELLO"));

        //new
        //****IMPORTANT****
        System.out.println("""
               <html>
                <head><head>
                <body>%s</body>
               </html>
               """.formatted("Hello"));


    }

}
