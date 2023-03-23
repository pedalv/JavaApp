package no.dfo.whatsnewinjava.textblocks.stringmethods;

public class MainStripIdent {

    public static void main(String ...args) {
        String html = """
                <!DOCTYPE html>
                <html>
                <head>
                <title>Page Title</title>
                </head>
                <body>
                                
                <h1>This is a Heading</h1>
                <p>This is a paragraph.</p>
                                
                </body>
                </html>""";
        System.out.println(html.stripIndent()); //
        System.out.println("---");
        var text = "\n\t   text   \u2005";
        System.out.println(text.strip()); //"Text"
        System.out.println("---");
        System.out.println(text.stripIndent()); //
        System.out.println("---");
        System.out.println(text.trim()); // "Text   ?"
        System.out.println("---");
        System.out.println(Character.isWhitespace('\u2005')); //true
        System.out.println("---");

        /*
        <!DOCTYPE html>
        <html>
        <head>
        <title>Page Title</title>
        </head>
        <body>

        <h1>This is a Heading</h1>
        <p>This is a paragraph.</p>

        </body>
        </html>
        ---
        text
        ---

        text
        ---
        text   ?
        ---
        true
        ---
         */
    }

}
