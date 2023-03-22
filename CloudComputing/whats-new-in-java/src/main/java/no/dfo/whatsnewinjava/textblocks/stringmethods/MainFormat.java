package no.dfo.whatsnewinjava.textblocks.stringmethods;

public class MainFormat {

    public static void main(String ...args) {
        textformatted();
    }

    private static void textformatted() {
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
