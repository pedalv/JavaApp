package no.das.boot;

import no.das.boot.controller.HomeController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by p on 12/09/2016.
 */
public class DasTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    //JUNIT TEST
    @Test
    public void testApp() {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals( result, "Das Boot, reporting for duty!" );
    }


}