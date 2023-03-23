package no.dfo.whatsnewinjava.textblocks.stringmethods;

public class MainEmpty {

    public static void main(String ...args) {
        var notext = "      ";
        System.out.println(notext.isEmpty()); //false

        var emptytext = "";
        System.out.println(emptytext.isEmpty()); //true
    }
}
