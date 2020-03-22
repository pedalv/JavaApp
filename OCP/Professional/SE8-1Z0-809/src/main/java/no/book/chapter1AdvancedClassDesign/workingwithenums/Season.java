package no.book.chapter1AdvancedClassDesign.workingwithenums;

/*
Adding Constructors, Fields, and Methods
 */
public enum Season {
    /*
    WINTER,
    SPRING,
    SUMMER,
    FALL
    */

    WINTER("Low") {
        public void printHours() { System. out .println("9am-3pm"); }
        },
    SPRING("Medium"){
        public void printHours() { System. out .println("9am-5pm"); }
        },
    SUMMER("High") {
        public void printHours() { System. out .println("9am-7pm"); }
        },
    FALL("Medium") {
        public void printHours() { System. out .println("9am-5pm"); }
    };
    // we have a semicolon.
    // This is required if there is anything in the enum besides the values.
    /*
    This is such a subtle detail that we are going to say it again:
    remember that the semicolon at the end of the enum values is optional
        only if the only thing in the enum is that list of values.
     */

    private String expectedVisitors;

    /*
    The constructor is private because it can only be called from within the enum .
    The code will not compile with a public constructor.
     */
    private Season(String expectedVisitors) {
         this.expectedVisitors = expectedVisitors;
    }

    /*
    Calling this new method is easy: Season.SUMMER.printExpectedVisitors();
     */
    public void printExpectedVisitors() {
         System.out.println(expectedVisitors);
    }

    /*
    This technique of a constructor and state allows you to combine logic with the benefit of a list of values.
    Sometimes, you want to do more. For example, our zoo has different seasonal hours.
    It is cold and gets dark early in the winter. We could keep track of the hours through instance variables,
        or we can let each enum value manage hours itself.

    What’s going on here?
    It looks like we created an abstract class and a bunch of tiny subclasses. In a way we did.
    The enum itself has an abstract method.
    This means that each and every enum value is required to implement this method.
    If we forget one, we get a compiler error.

    Error: java: no.book.chapter1AdvancedClassDesign.workingwithenums.Season is abstract; cannot be instantiated

    If we don’t want each and every enum value to have a method, we can create a default
        implementation and override it only for the special cases:

        public enum Season3 {
            WINTER {
            public void printHours() { System.out.println("short hours"); }
            },
            SUMMER {
            public void printHours() { System.out.println("long hours"); }
            },
            SPRING,
            FALL;
            public void printHours() { System.out.println("default hours"); }
            }
        }
     */
    public abstract void printHours();

}