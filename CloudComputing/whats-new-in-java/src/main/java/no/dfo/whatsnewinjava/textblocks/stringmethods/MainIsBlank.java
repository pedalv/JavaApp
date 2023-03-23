package no.dfo.whatsnewinjava.textblocks.stringmethods;

public class MainIsBlank {

    public static void main(String ...args) {
        var notext = "      ";

        System.out.println("".equals(notext.trim())); //true
        System.out.println(notext.isBlank()); //true

    }

}
