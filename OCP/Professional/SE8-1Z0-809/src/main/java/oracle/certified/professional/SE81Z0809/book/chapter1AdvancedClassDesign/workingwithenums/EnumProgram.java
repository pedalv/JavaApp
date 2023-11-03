package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.workingwithenums;

/*
An enumeration is like a fixed set of constants.
In Java, an enum is a class that represents an enumeration.
It is much better than a bunch of constants because it provides type‐safe checking.
With numeric constants, you can pass an invalid value and not find out until runtime.
With enums, it is impossible to create an invalid enum type without introducing a compiler error.

Common examples are the days of the week, months of the year, the planets in
the solar system, or the cards in a deck.

Since an enum is like a set of constants, use the uppercase letter convention that you used for constants.

enums print the name of the enum when toString() is called.
They are also comparable using == because they are like static final constants.
An enum provides a method to get an array of all of the values.

Season.values()
season.name()
season.ordinal()

Another thing that you can’t do is extend an enum.
public enum ExtendedSeason extends Season { } // DOES NOT COMPILE
The values in an enum are all that are allowed.
You cannot add more at runtime by extending the enum.

Just because an enum can have lots of methods, doesn’t mean that it should.
Try to keep your enums simple.
If your enum is more than a page or two, it is way too long.
Most enums are just a handful of lines.
The main reason they get long is that when you start with a one or two‐line method and then
    declare it for each of your dozen enum types, it grows long.
When they get too long or too complex, it makes the enum hard to read.
 */
public class EnumProgram {

    public static void main(String ... args) {

        WorkingwithEnums();

        UsingEnumsinSwitchStatements();

        GetTheAlreadyConstructedenumValues();
    }

    private static void GetTheAlreadyConstructedenumValues() {
        OnlyOne firstCall = OnlyOne. ONCE ; // prints constructing
        OnlyOne secondCall = OnlyOne. ONCE ; // doesn't print anything
    }

    private static void WorkingwithEnums() {
        Season s = Season.SUMMER;
        System.out.println(Season.SUMMER); // SUMMER
        System.out.println(s == Season.SUMMER); // true
        System.out.println(s + s.name() + " ---- " + s.ordinal()); // SUMMER

        for(Season season: Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }

        //if ( Season.SUMMER == 2) {} // DOES NOT COMPILE
        // Error:(37, 28) java: incomparable types: no.book.chapter1AdvancedClassDesign.workingwithenums.Season and int
        /*
        You can’t compare an int and enum value directly anyway.
        Remember that an enum is a type and not an int.

        You can also create an enum from a String.
        This is helpful when working with older code.
        The String passed in must match exactly, though.
         */

        Season s1 = Season.valueOf("SUMMER"); // SUMMER
        System.out.println(s1);
        try {
            Season s2 = Season.valueOf("summer"); // exception
            // java.lang.IllegalArgumentException:
            // No enum constant no.book.chapter1AdvancedClassDesign.workingwithenums.Season.summer
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        Season.SUMMER.printExpectedVisitors(); // High

        Season.SUMMER.printHours(); // 9am-7pm

        Season3.SUMMER.printHours(); // long hours
        Season3.FALL.printHours(); // default hours

    }

    private static void UsingEnumsinSwitchStatements() {
        Season summer = Season.SUMMER;
        switch (summer) {
            case WINTER:
                System.out.println("Get out the sled!");
                break;
            case SUMMER:
                System.out.println("Time for the pool!");
                break;
            default:
                System.out.println("Is it summer yet?");
        }
    }

}


