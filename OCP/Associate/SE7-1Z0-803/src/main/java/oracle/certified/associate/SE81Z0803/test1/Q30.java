package oracle.certified.associate.SE81Z0803.test1;

/**
 * Created by pedro alves on 24/05/15.
 */
public class Q30 {
    public static void main(String ... args){

        StringBuilder b1 = new StringBuilder("snorkler");
        StringBuilder b2 = new StringBuilder("yoodler");

        System.out.println("b2-INIT: " + b2);
        System.out.println(b2.substring(2,5).toUpperCase());
        System.out.println("b2-END: " + b2);
        System.out.println("b1-INIT: " + b1);
        System.out.println(b1.append(b2.substring(2,5).toUpperCase()));
        System.out.println("b1-END: " + b1);

        b1 = new StringBuilder("snorkler");
        b2 = new StringBuilder("yoodler");

        System.out.println("b2-INIT: " + b2);
        System.out.println(b2.insert(3,b1.append("a")));
        System.out.println("b2-END: " + b2);
        System.out.println("b1-INIT: " + b1);
        System.out.println(b1.append("a"));
        System.out.println("b1-END: " + b1);



        b1 = new StringBuilder("snorkler");
        b2 = new StringBuilder("yoodler");

        //OSV
    }




}



/*
You need to understand how
append, insert, delete, and
substring methods of StringBuilder/StringBuffer work.

Please go through JavaDoc API for these methods.

This is very important for the exam.

Observe that substring() does not modify the object it is invoked on
but append, insert and delete do.

In the exam, you will find questions that use such quirky syntax,
where multiple calls are chained together.

For example:
sb.append("a").append("asdf").insert(2, "asdf").

Make yourself familiar with this technique.
If in doubt, just break it down into multiple calls.
For example, the aforementioned statement can be thought of as:
sb.append("a");
sb.append("asdf");
sb.insert(2, "asdf")

Note that the method substring() in StringBuilder/StringBuffer
returns a String (and not a reference to itself, unlike append, insert, and delete).

So another StringBuilder method cannot be chained to it.
For example, the following is not valid:
sb.append("a").substring(0, 4).insert(2, "asdf");

The following is valid though:  
String str = sb.append("a").insert(2, "asdf").substring(0, 4);

 */
