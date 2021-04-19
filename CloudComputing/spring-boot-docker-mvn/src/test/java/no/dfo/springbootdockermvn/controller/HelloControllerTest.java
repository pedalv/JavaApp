package no.dfo.springbootdockermvn.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HelloControllerTest {

    private HelloController helloController;

    @BeforeEach
    void setUp() {
        helloController = new HelloController();
    }

    @Test
    void testHome_returnString() {
        //given

        //when
        String expected = "Hello Docker World With Maven";
        String actual = helloController.home();

        //then
        assertEquals(expected, actual);
    }

}