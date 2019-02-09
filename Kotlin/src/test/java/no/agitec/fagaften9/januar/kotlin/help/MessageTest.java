package no.agitec.fagaften9.januar.kotlin.help;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageTest {

    private String expected;

    @Before
    public void setUp() throws Exception {
        expected = "Hei - Hello - Hallo - Olá - ...";;
    }

    @After
    public void tearDown() throws Exception {
        expected = null;
    }

    @Test
    public void getX() {
        String actual = Message.x();
        Assert.assertEquals("Message is not equal", expected, actual);
    }
}