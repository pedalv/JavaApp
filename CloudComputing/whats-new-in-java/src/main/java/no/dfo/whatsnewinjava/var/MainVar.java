package no.dfo.whatsnewinjava.var;

import java.util.List;

/**
 * var is used as a local variable only
 */
public class MainVar {

    //var nope = "no, really!";  error: 'var' is not allowed here
    String yes = "yes, really!";
    public static void main(String...args) {
        //var num; error: cannot infer type for local variable num
        var num = 1;
        var nums = new int[]{1, 2, 3};
        //var  nums2 = {1, 2, 3}; //error: cannot infer type for local variable nums2
        int[] nums3 = {1, 2, 3};

        for(int n: nums) { }
        for(var n: nums) { }

        SomeBigUglyTypeNameHappensToTheBest ugly = new SomeBigUglyTypeNameHappensToTheBest();
        var uglyvar = new SomeBigUglyTypeNameHappensToTheBest();

        List<SomeBigUglyTypeNameHappensToTheBest> uglies = List.of(ugly);
        var ugliesvar = List.of(ugly);

        var moreUglies = List.copyOf(ugliesvar);

        //nonono
        //var a = Book.getBook().getAuthors().stream().findFirst().map(String::kength).orElse(0);

        //var authors = Book.getBook().getAuthors();
        //var firstAuthor = authors.stream().findFirst();
        //var length = firstAuthor.map(String::kength).orElse(0);

        //var empty = null; //error: cannot infer type for local variable empty

        //Anonymous calss instances
        var obj = new Object() { };
        //obj = new Object(); //error: incompatible types: Object cannot be converted to <anonymous Object>

        //Intersection types
        var list = List.of(1, 2.0, "3");
        //List<? extends Serializable & Comparable<..>>
        //All of these types may show up in errors

    }

}

