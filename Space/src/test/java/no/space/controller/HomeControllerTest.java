package no.space.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeControllerTest {

    @Test
    public void testPassFine() {
        assertEquals(true,true);
    }

    @Test
    public void testHome() throws Exception {
        String actual = "Case coffee machine project for Spring Boot";

        HomeController hc = new HomeController();
        String expected = hc.home();

        assertEquals( expected, actual );
    }

}