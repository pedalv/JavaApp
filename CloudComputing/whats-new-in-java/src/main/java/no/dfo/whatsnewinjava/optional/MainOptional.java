package no.dfo.whatsnewinjava.optional;

import java.util.Optional;

public class MainOptional {

    public static void main(String ...args) {
        var opt = Optional.ofNullable(null);
        Optional<Object> opt2 = Optional.ofNullable("null");

        opt.isEmpty(); //True
        var optEmpty = Optional.ofNullable(null).isEmpty(); //true
        var opt2Empty = Optional.ofNullable("null").isEmpty(); //false

        opt.isPresent(); //false
        var optPresent = Optional.ofNullable(null).isPresent();//false
        var opt2Present = Optional.ofNullable("null").isPresent(); //true
    }
}
