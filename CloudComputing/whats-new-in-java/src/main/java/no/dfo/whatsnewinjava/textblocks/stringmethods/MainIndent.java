package no.dfo.whatsnewinjava.textblocks.stringmethods;

public class MainIndent {

    public static void main(String ...args) {
        System.out.println("hello".indent(2)); //"  hello\n"

        var multiline = "This\nisa\nmulti-line\nString";
        System.out.println(multiline);
        multiline.lines().forEach(System.out::println);
        //This
        //isa
        //multi-line
        //String

        var indented = multiline.indent(5);
        System.out.println(indented);
        indented.lines().forEach(System.out::println);
        //     This
        //     isa
        //     multi-line
        //     String

        indented.indent(-3).lines().forEach(System.out::println);
        //  This
        //  isa
        //  multi-line
        //  String

    }

}
