package no.book.chapter1AdvancedClassDesign.workingwithenums;

public enum Season3 {
    WINTER {
        public void printHours() { System.out.println("short hours"); }
    },
    SUMMER {
        public void printHours() { System.out.println("long hours"); }
    },
    SPRING,
    FALL;
    /*
    Notice how we still have the semicolon after FALL.
    This is needed when we have anything other than just the values.
     */

    /*
    In this case, we have a default method implementation.
     */
    public void printHours() { System.out.println("default hours"); }

}
