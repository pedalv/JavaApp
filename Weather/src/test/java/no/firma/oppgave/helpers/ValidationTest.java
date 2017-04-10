package no.firma.oppgave.helpers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by p on 13/01/2017.
 */
public class ValidationTest {
    @Test
    public void isValidString_true() throws Exception {
        Boolean expected = true;
        Boolean actual = Validation.isValidString("åøæ");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isValidString_Empty_false() throws Exception {
        Boolean expected = false;
        Boolean actual = Validation.isValidString("");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isValidString_space_false() throws Exception {
        Boolean expected = false;
        Boolean actual = Validation.isValidString("      ");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isValidString_null_false() throws Exception {
        Boolean expected = false;
        Boolean actual = Validation.isValidString(null);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isValidEmailAddress_True() throws Exception {
        Boolean expected = true;
        Boolean actual = Validation.isValidEmailAddress("alves.pedro0@gmail.com");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isValidEmailAddress_False() throws Exception {
        Boolean expected = false;
        Boolean actual = Validation.isValidEmailAddress("alves.pedro0@.gmail.com");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isValidURL_True() throws Exception {
        String url = "http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml";
        Boolean expected = true;
        Boolean actual = Validation.isValidURL(url);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isValidURL_False() throws Exception {
        String url = "http://www.yr/sted/Norge/Sør-Trøndelag/Frøya/Svalbalen/varsel_time_for_time.xml";
        Boolean expected = false;
        Boolean actual = Validation.isValidURL(url);
        Assert.assertEquals(expected, actual);
    }

}