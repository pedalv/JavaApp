package no.book.appendixB;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudyTipsTest {

    private String expected;
    private String actual;


    @Before
    public void setUp() throws Exception {
        expected = "Hei M";

        actual = StudyTips.defaultedRegards();

    }

    @After
    public void tearDown() throws Exception {

        expected = null;

        actual = null;

    }

    @Test
    public void defaultedRegards() {

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void main() {

        Assert.assertNotEquals(expected + "PP", actual);

    }

}