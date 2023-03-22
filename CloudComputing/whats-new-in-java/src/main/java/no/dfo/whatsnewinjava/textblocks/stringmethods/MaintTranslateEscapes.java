package no.dfo.whatsnewinjava.textblocks.stringmethods;

public class MaintTranslateEscapes {

    public static void main(String ...args) {
        textTranslateEscapes();
    }

    private static void textTranslateEscapes() {
        //String text = Files.readString(Path.of("\"Hello\tWorld\"\n"));

        String text = "\"Hello\tWorld\"\n";
        System.out.println(text);
        //****IMPORTANT****
        System.out.println(text.translateEscapes());
    }

}
