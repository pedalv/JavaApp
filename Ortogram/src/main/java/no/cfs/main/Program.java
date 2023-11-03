package no.cfs.main;

import no.cfs.helper.FileWordData;
import no.cfs.helper.Ortogram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p on 10/11/2016.
 */
public class Program {

    private String fileName;
    private List<String> wordList;
    private List<String> sortwordList;

    Program(){
        fileName = "d://ortogramWords.txt";
        wordList = new ArrayList();
    }

    private List<String> populateWordList() {
        wordList.add("niste");
        wordList.add("stien");
        wordList.add("allfarvein");
        wordList.add("konsert");

        return wordList;
    }


    public static void main(String[] args){
        Program run = new Program();
        Ortogram ortogram = new Ortogram();

        run.setWordList(FileWordData.ReadFile(run.fileName));
        //run.populateWordList();

        ortogram.sortPopulateList(run.getWordList());
        run.setSortwordList(ortogram.getSortWordList());

        //wordList.forEach(System.out::println);
        //sortwordList.forEach(System.out::println);

        int skip = 0;
        List<Integer> indexToOrtogramWord = new ArrayList<>();

        for (String sortword : run.getSortwordList()) {
            indexToOrtogramWord = ortogram.findOrtogramWord(sortword, ++skip);

            if(indexToOrtogramWord.size() > 1) {
                break;
            }
        }

        String ortogramWord = "";
        for(int index : indexToOrtogramWord){
            ortogramWord += " " + run.getWordList().get(index);
        }

        if(ortogramWord.isEmpty()) {
            System.out.println(" List has not ortogram words");
        } else {
            System.out.println(ortogramWord);
        }

    }

    public List<String> getWordList() {
        return wordList;
    }

    public void setWordList(List<String> wordList) {
        this.wordList = wordList;
    }

    public List<String> getSortwordList() {
        return sortwordList;
    }

    public void setSortwordList(List<String> sortwordList) {
        this.sortwordList = sortwordList;
    }
}
