package no.dfo.whatsnewinjava.textblocks.stringmethods;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringTransform {


    public static void main(String ...args){
        var text = "$some text $with$ $dollars";
        var textarray = StringUtils.words(StringUtils.clean(text)); // ["some", "text", "with", "dollars"]

        var textarraytransform =
                text.transform(String::toUpperCase)
                .transform(StringUtils::clean)
                .transform(StringUtils::words); //["SOME", "TEXT", "WITH", "DOLLARS"]

    }

}
