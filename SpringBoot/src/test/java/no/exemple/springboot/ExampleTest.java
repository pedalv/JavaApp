package no.exemple.springboot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by p on 08/09/2016.
 */
public class ExampleTest {

    private Example ex;

    @Before
    public void setUp() throws Exception {
        ex = new Example();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testHome() throws Exception {
        String expected = "Hello World!";
        assertEquals(expected, ex.home());
    }

}