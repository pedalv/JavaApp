package no.insurance.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by p on 22/10/2016.
 */
public class HomeControllerTest {

    @Test
    public void testHome() throws Exception {
        String actual = "Case insurance contract project for Spring Boot";

        HomeController hc = new HomeController();
        String expected = hc.home();

        assertEquals( expected, actual );
    }
}