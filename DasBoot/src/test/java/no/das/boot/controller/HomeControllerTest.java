package no.das.boot.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by p on 14/09/2016.
 */
public class HomeControllerTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testHome() throws Exception {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals( result, "Das Boot, reporting for duty!" );
    }

}