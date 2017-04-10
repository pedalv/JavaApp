package no.cfs.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by p on 10/11/2016.
 */
public class Ortogram {

    private List<String> sortWordList = new ArrayList();
    private int endIndex = 0;

    public String sortWord(String word) {

        char [] arrayWord = word.toLowerCase().toCharArray();

        Arrays.sort(arrayWord);

        String sorted = "";
        for (char anArrayWord : arrayWord) {
            sorted += anArrayWord;
        }

        //System.out.println(sorted);

        return sorted;
    }

    public void sortPopulateList(List<String> wordList){
        for(String word : wordList) {
            word = sortWord(word);
            sortWordList.add(word);
        }
    }

    public List<Integer> findOrtogramWord(String word, long skip) {
        int index = (int) (skip - 1);

        List<Integer> indexsFound = new ArrayList<>();
        indexsFound.add(index++);

        for(String ortagramword: sortWordList.stream().skip(skip).collect(Collectors.toList())) {

            if(ortagramword.equals(word)){
                indexsFound.add(index);
            }

            index += 1;
        }

        return indexsFound;
    }

    public List<String> getSortWordList() {
        return sortWordList;
    }

}
