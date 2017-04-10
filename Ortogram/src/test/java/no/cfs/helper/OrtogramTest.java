package no.cfs.helper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p on 10/11/2016.
 */
public class OrtogramTest {

    private Ortogram ortogram;
    private List<String> wordList;
    private String name;

    @Before
    public void setUp() throws Exception {
        ortogram = new Ortogram();
        name = "Pedro";
        wordList = new ArrayList<String>();
        wordList = populateWordList();
    }

    private List<String> populateWordList() {
        wordList.add("niste");
        wordList.add("stien");
        wordList.add("allfarvein");
        wordList.add("konsert");

        return wordList;
    }


    @Test
    public void testSortWord() throws Exception {
        String expected = "deopr";//"Pdeor";
        String actual = ortogram.sortWord(name);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortPopulateList() throws Exception {
        String expected1 = "einst";
        String expected2 = "aaefillnrv";
        ortogram.sortPopulateList(wordList);
        List<String> actuaList = ortogram.getSortWordList();

        Assert.assertEquals(expected1, actuaList.get(0));
        Assert.assertEquals(expected2, actuaList.get(2));
    }


    @Test
    public void testFindOrtogramWord() throws Exception {
        int skip = 1;
        int expected = 2;
        ortogram.sortPopulateList(wordList);

        int actualIndexsFound = ortogram.findOrtogramWord("einst", skip).size();

        Assert.assertEquals(expected,actualIndexsFound);
    }
}