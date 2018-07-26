package no.book.AppendixC;

import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UpgradingfromJava6orEarlier {

    public static void main(String ... args) {

        usingtheDiamondOperator();
        creatingLiterals();
        makingDecisionswithSwitch();
        FormattingandParsing();
        ApplyingLocks();
        DuplicatingLockRequests();

    }

    private static void DuplicatingLockRequests() {

        // Duplicating Lock Requests

        // problem with two locks and one unlock
        final Lock lock2 = new ReentrantLock();

        int birdCount = 0;
        try {
            lock2.lock();
            lock2.lock();
            ++birdCount;
        } finally {
            lock2.unlock();
        }
        new Thread(() -> {
            // java: local variables referenced from a lambda expression must be final or effectively final
            if(lock2.tryLock()) {
                try {
                    System.out.println("Acquired");
                } finally {
                    lock2.unlock();
                }
            } else {
                System.out.println("Unavailable");
            }
        }).start();

        //OUTPUT : Unavailable
        /*
        The result is that the unlock() method must be called
            the same number of times as the lock() method in order to release the lock.
        Therefore, this code outputs Unavailable , since the lock is still maintained by the original thread.
         */


        // two locks and two unlocks

        final Lock lock3 = new ReentrantLock();
        try {
            lock3.lock();
            try {
                lock3.lock();
                ++birdCount;
            } finally {
                lock3.unlock();
            }
        } finally {
            lock3.unlock();
        }
        new Thread(() -> {
            // Error: java: local variables referenced from a lambda expression must be final or effectively final
            if(lock3.tryLock()) {
                try {
                    System.out.println("Acquired");
                    // ++birdCount; // DOES NOT COMPILE // Error: java: local variables referenced from a lambda expression must be final or effectively final
                } finally {
                    lock3.unlock();
                }
            } else {
                System.out.println("Unavailable");
            }
        }).start();

        // OUTPUT : Acquired


        // Fair Lock Management => thread starvation

        /*
        By default, when a ReentrantLock releases a lock, it then assigns it to a waiting thread at
            random if there are any, in the same manner as synchronized . This could potentially lead
            to thread starvation, as a thread that has been waiting a long time may continually lose the
            lock to another thread.
        The ReentrantLock class has the optional feature that the thread that has been waiting
            the longest can be guaranteed the lock the next time it is released. This property is often
            referred to as fairness , and it corresponds to a FIFO ordering, as discussed in Chapter 3 ,
            “Generics and Collections.”
         */

        Lock lock = new ReentrantLock(true);

        /*
        When the boolean value is set to true , fairness is enabled and the longest waiting thread
            is guaranteed to obtain the lock the next time it is released.
        When the boolean value is set to false , the lock defaults to its normal, no-argument constructor behavior,
            and it assigns the lock randomly upon its release.
         */

        /*
        As even Oracle’s documentation for the ReentrantLock class points out,
            enabling fairness may not have the desired outcome and could significantly
            slow down your program under certain circumstances. Therefore,
            you should use it only in situations where you really need your requests
            ordered in a particular manner.
         */
    }

    private static void ApplyingLocks() {

        // Understanding the Lock Framework

        // Implementation #1 with synchronization
        Object object = new Object();
        int birdCount = 0;
        synchronized(object) {
            System.out.print(" "+(++birdCount));
        }

        // Implementation #2 with a Lock
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.print(" "+(++birdCount));
        } finally {
            lock.unlock();
            /*
            It is considered a good code practice to put the unlock() method in a finally
                block, as you saw in the previous example. This is similar to avoiding memory or database leaks
                by closing resources, as you saw in Chapter 8 , “IO,” and Chapter 10 , “JDBC,” respectively.
             */
        }

        /*
        The Lock framework ensures that once a thread has called the lock() method, all other
            threads that call lock() will wait until the thread that acquired the lock calls the unlock() method.
        As far as which thread gets the lock next, that depends on the lock implementation
            class and parameters used.
         */

        /*
        While the two snippets of code are conceptually equivalent, they are not compatible with each other.
        For example, if one thread calls lock() on a Lock object while another thread uses the synchronized
            keyword on the same Lock object, the code will not be thread-safe.
        In other words, you can’t mix and match the Lock framework and the synchronized keyword, as the Lock
            framework is an alternative to synchronization.
         */

        lock = new ReentrantLock();
        //lock.unlock(); // Throws IllegalMonitorStateException at runtime
        try {
            lock.unlock(); // Throws IllegalMonitorStateException at runtime
        } catch (IllegalMonitorStateException e) {
            System.out.println( " - " + e);
        }

        lock = new ReentrantLock();
        if(lock.tryLock()) {
            try {
                System.out.print(" "+(++birdCount));
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Unable to acquire lock, doing something else");
        }

        lock = new ReentrantLock();
        try {
            if(lock.tryLock(10,TimeUnit.SECONDS)) { // waits up to 10 seconds when trying to acquire the lock
                try {
                    System.out.print(" "+(++birdCount));
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Unable to acquire lock, doing something else");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void FormattingandParsing() {

        //public class DecimalFormat extends NumberFormat
        //DecimalFormat Formatting Characters

        double d = 1234567.437;

        DecimalFormat one = new DecimalFormat("###,###,###.###");
        System.out.println(one.format(d)); // 1,234,567.437
        // 1 234 567,437
        // Displays just the digits in the number. The extra positions are omitted because we used #.

        DecimalFormat two = new DecimalFormat("000,000,000.00000");
        System.out.println(two.format(d)); // 001,234,567.43700
        // 001 234 567,43700
        // Adds leading and trailing zeros to make the output the desired length.

        DecimalFormat three = new DecimalFormat("$#,###,###.##");
        System.out.println(three.format(d)); // $1,234,567.44
        // $1 234 567,44
        // Shows prefixing a non-formatting character ($ sign) along with rounding because fewer digits are printed than available.

        new NumberFormat() {
            @Override
            public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
                return null;
            }

            @Override
            public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
                return null;
            }

            @Override
            public Number parse(String source, ParsePosition parsePosition) {
                return null;
            }
        };

        // Using DateFormat
        //As with NumberFormat, you need to create a DateFormat before formatting or parsing.
        //In fact, both classes extend a common Format superclass.
        //The DateFormat class provides factory methods to get the desired formatter.
        /*
        For formatting dates
        DateFormat.getDateInstance()
        DateFormat.getDateInstance(style)
        DateFormat.getDateInstance(style, locale)
        */
        /*
        For formatting times DateFormat.getTimeInstance()
        DateFormat.getTimeInstance(style)
        DateFormat.getTimeInstance(style, locale)
        */
        /*
        For formatting dates and times
        DateFormat.getDateTimeInstance()
        DateFormat.getDateTimeInstance(dateStyle, timeStyle)
        DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale)
        */
        /*
        Many of the factory methods take a style parameter.
        You can pass FULL, LONG, MEDIUM, and SHORT to specify the amount of detail that you want in the format.
        Once you have the DateFormat instance, you can call format() to turn a number into a String and parse() to
        turn a String into a number.
         */

        DateFormat s = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat m = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat l = DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);

        //public final String format(Date date)
        //The date parameter is of type java.util.Date

        Date date = new GregorianCalendar(2018, Calendar.JULY, 26).getTime();
        System.out.println(s.format(date)); // 26.07.18
        System.out.println(m.format(date)); // 26.jul.2018
        System.out.println(l.format(date)); // 26. juli 2018
        System.out.println(f.format(date)); // 26. juli 2018

        DateFormat dtf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL);
        System.out.println(dtf.format(date)); // 26.jul.2018 kl 00.00 CEST

        DateFormat de = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL, Locale.GERMANY);
        System.out.println(de.format(date)); // 26.07.2018 00:00 Uhr MESZ

        // Parsing

        /*
        The DateFormat class contains the following parse method for parsing strings into dates:
            public Date parse(String source) throws ParseException.
        The return value is of type java.util.Date,
            and the ParseException is thrown when the beginning of the string cannot be parsed into a date successfully.
        The format of the String object depends on both the style and the locale of the
            DateFormat object.
         */

        DateFormat shortFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
        String str = "01/31/1984";
        try {
            date = shortFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat fullFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE);
        System.out.println(fullFormat.format(date));

        // Custom Date Formats
        /*
        When you want to specify a custom format pattern, you use the SimpleDateFormat subclass.
        As with DecimalFormat , you use a constructor and pass in the desired format pattern.
        MMMM
            M represents the month. The more M s that you have, the more verbose the Java output is.
            For example, M outputs 1 , MM outputs 01 , MMM outputs Jan , and MMMM outputs January.

        dd
            d represents the day in the month.
            As with month , the more d s that you have, the more verbose the Java output is.
            dd means to include the leading zero for a single-digit day.

        yyyy
            y represents the year.
            yy outputs a two-digit year, and yyyy outputs a four-digit year.

        hh
            h represents the hour.
            Use hh to include the leading zero if you’re outputting a single-digit hour.

        mm
            m represents the minute.
            As with month and day, mm means to include the leading zero for a single-digit minute.

        ss
            s represents the second.
            As with minute, ss means to include the leading zero for a single-digit second.
         */

        SimpleDateFormat f1 = new SimpleDateFormat("MM dd yyyy hh:mm:ss");
        SimpleDateFormat f2 = new SimpleDateFormat("MMMM yyyy");
        SimpleDateFormat f3 = new SimpleDateFormat("hh");
        try {
            date = f1.parse("07 26 2018 11:55:33");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date); // Thu Jul 26 11:55:33 CEST 2018
        System.out.println(f1.format(date)); // 07 26 2018 11:55:33
        System.out.println(f2.format(date)); // juli 2018
        System.out.println(f3.format(date)); // 11

    }

    private static void makingDecisionswithSwitch() {

        // switch statements.

        /*
        Data types supported by switch statements include the following:
        ■■ int and Integer
        ■■ byte and Byte
        ■■ short and Short
        ■■ char and Character
        ■■ String
        ■■ enum values
         */

        /*
        Note that
        ■■ boolean
        ■■ and long
        ■■ and their associated wrapper classes are not supported by switch statements.
         */

        /*
        The values in each case statement must be compile-time constant values of the same
        data type as the switch value. This means that you can use only literals, enum constants,
        or final constant variables of the same data type. By final constant, we mean that the
        variable must be marked with the final modifier and initialized with a literal value in the
        same expression in which it is declared.
         */


        // Let’s look at a simple example using the day of the week, with 0 for Sunday, 1 for
        //Monday, and so on:

        int dayOfWeek = 5;
        switch(dayOfWeek) {
            default:
                System.out.println("Weekday");
                break;
            case 0_0: // In this example, we use the numeric literal 0_0 , which the compiler interprets as 0
                System.out.println("Sunday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
        }

        // With a dayOfWeek value of 5 , this code will output
        //Weekday

        switch(dayOfWeek) {}

        switch(dayOfWeek) {
            case 0_0:
                System.out.println("Sunday");
            default:
                System.out.println("Weekday");
            case 6:
                System.out.println("Saturday");
        }
        // With a dayOfWeek value of 5 , this code will output
        //Weekday
        //Saturday

        // With a dayOfWeek value of 6 , this code will output
        //Saturday

        // With a dayOfWeek value of 0 , this code will output
        //Sunday
        //Weekday
        //Saturday

    }

    private int getSortOrder(String firstName, final String lastName) {
        String middleName = "Patricia";
        final String suffix = "JR";
        int id = 0;
        switch(firstName) {
            /*
            The first case statement, "Test", compiles without issue using a String literal, and it is
            a good example of how a return statement, like a break statement, can be used to exit the
            switch statement early.
             */
            case "Test":
                return 52;

            /*
            case middleName: // DOES NOT COMPILE
                //The second case statement, middleName, does not compile because
                //middleName is not a final variable, despite having a known value at this particular line of
                //execution.
                id = 5;
                break;
            */

            case suffix:
                /*
                The third case statement, suffix, compiles without issue because suffix is a
                final constant variable.
                 */
                id = 0;
                break;

            /*
            case lastName: // DOES NOT COMPILE
                //The fourth case statement, lastName, does not compile, as the final variable is a
                //method argument that can change at runtime.
                id = 8;
                break;
            */

            /*
            //Finally, the last three case statements don’t
            //compile because none of them have a matching type of String, with the last one being an
            //enum value.
            case 5: // DOES NOT COMPILE
                id = 7;
                break;
            case 'J': // DOES NOT COMPILE
                id = 10;
                break;
            case Month.JANUARY: // DOES NOT COMPILE
                id=15;
                break;
            */
        }
        return id;
    }

    private static void creatingLiterals() {

        // new formats for literals

        /*
        When a number is present in the code, it is a type of literal.
        By default, Java assumes that you are defining an int value with a literal.
         */

        //long max = 3123456789; // DOES NOT COMPILE
        //Error:(30, 20) java: integer number too large: 3123456789

        long max = 3123456789L; // now Java knows it is a long



        /*
        The decimal number system or base 10 since there are 10 numbers.

        Java allows you to specify digits in several other formats:
        -> Decimal (Digits 0-9), for example, 2018
        -> Octal (Digits 0–7) This format uses the number 0 as a prefix, for example, 017.
        -> Hexadecimal (Digits 0–9 and Letters A–F) This format uses the number 0 followed by x
        or X as a prefix, for example, 0xFF.
        -> Binary (Digits 0–1) This format uses the number 0 followed by b or B as a prefix, for
        example, 0b10.
         */

        // Literals with Underscore Characters

        int million1 = 1000000;
        int million2 = 1_000_000; // We’d rather be reading the latter example because the zeroes don’t run together.

        // You can add underscores anywhere except at the beginning of a literal,
        // the end of a literal, right
        //before a decimal point,
        // or right after a decimal point.
        // Let’s look at a few examples:
        //double notAtStart = _1000.00; // DOES NOT COMPILE
        //double notAtEnd = 1000.00_; // DOES NOT COMPILE
        //double notByDecimal = 1000_.00; // DOES NOT COMPILE
        //double annoyingButLegal = 1_00_0.0_0; // this one compiles

    }

    private static void usingtheDiamondOperator() {

        // the diamond operator <>

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<>();

        // the diamond operator <> is that it can be used for
        //embedded collection types.

        Map<Map<String,Integer>,List<Double>> map1
                = new HashMap<Map<String,Integer>, List<Double>>();
        Map<Map<String,Integer>,List<Double>> map2 = new HashMap<>();

        /*
        Map<Map<String,Integer>,List<Double>> map3
                = new HashMap<<>,<>>(); // DOES NOT COMPILE

        List<> list1 = new ArrayList<String>(); // DOES NOT COMPILE
        */

    }

}
