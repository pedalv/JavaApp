package no.dfo.javamodularity.easytext.analysis.internal;

public class SyllableCounter {

    public static int countSyllables(String word) {
        int syllables = 0;
        boolean prevNonVowel = false;
        for(int i = 0; i < word.length(); i++) {
            boolean isVowel = isVowel(word.toLowerCase().charAt(i));
            if(prevNonVowel && isVowel && i != word.length() - 1) {
                syllables++;
            }
            prevNonVowel = !isVowel;
        }
        syllables = syllables == 0 ? 1 : syllables;
        return syllables;
    }

    private static boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }

}
