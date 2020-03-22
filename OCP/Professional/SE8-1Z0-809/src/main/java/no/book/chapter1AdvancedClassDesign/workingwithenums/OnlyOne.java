package no.book.chapter1AdvancedClassDesign.workingwithenums;

/*
Notice how we don’t appear to call the constructor.
We just say that we want the enum value.
The first time that we ask for any of the enum values, Java constructs all of the enum values.
After that, Java just returns the already‐constructed enum values.
 */
public enum OnlyOne {

    ONCE (true);

    private OnlyOne(boolean b) {
        System. out .println("constructing");
    }

}
