package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q11;

public class MySecret implements Secret {
    public String magic(double d) {
        //return "Poof";

        //String sa = (e) -> "Poof";

        //String sb = (e) -> { "Poof"}; // b

        // String s = (e) -> { String e = ""; "Poof" }; // c d e NO

        //String sf = (e) -> { String f = ""; return "Poof"};

        return "";
    }
}

/*

Which lambda can replace the MySecret class to return the same value?
(Choose all that apply.)

A. caller((e) -> "Poof");
    B. caller((e) -> {"Poof"});
    C. caller((e) -> { String e = ""; "Poof" });
    D. caller((e) -> { String e = ""; return "Poof"; });
    E. caller((e) -> { String e = ""; return "Poof" });
F. caller((e) -> { String f = ""; return "Poof"; });

ANSWER


 */