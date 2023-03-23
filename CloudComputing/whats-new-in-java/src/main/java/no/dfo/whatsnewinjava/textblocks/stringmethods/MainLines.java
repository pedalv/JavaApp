package no.dfo.whatsnewinjava.textblocks.stringmethods;

import java.nio.file.Files;

public class MainLines {

    public static void main(String ...args) {
        var multiline = "1\n2\n3\n4";
        multiline.lines().forEach(System.out::println);
        /*
        1
        2
        3
        4
         */


        /*
        -         Files.readString()

        public static String readString(Path path) throws IOException {
            return readString(path, UTF_8.INSTANCE);
        }

        public static String readString(Path path, Charset cs) throws IOException {
            Objects.requireNonNull(path);
            Objects.requireNonNull(cs);

            byte[] ba = readAllBytes(path);
            if (path.getClass().getModule() != Object.class.getModule())
                ba = ba.clone();
            return JLA.newStringNoRepl(ba, cs);
        }

        - Files.writeString()
        public static Path writeString(Path path, CharSequence csq, OpenOption... options)
            throws IOException
        {
            return writeString(path, csq, UTF_8.INSTANCE, options);
        }

        public static Path writeString(Path path, CharSequence csq, Charset cs, OpenOption... options)
            throws IOException
        {
            // ensure the text is not null before opening file
            Objects.requireNonNull(path);
            Objects.requireNonNull(csq);
            Objects.requireNonNull(cs);

            byte[] bytes = JLA.getBytesNoRepl(String.valueOf(csq), cs);
            if (path.getClass().getModule() != Object.class.getModule())
                bytes = bytes.clone();
            write(path, bytes, options);

            return path;
        }

         */


    }
}
