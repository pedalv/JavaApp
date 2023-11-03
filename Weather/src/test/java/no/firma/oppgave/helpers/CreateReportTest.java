package no.firma.oppgave.helpers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by p on 18/01/2017.
 */
public class CreateReportTest {

    CreateReport cr;
    MailSender mailSender;
    String forecastUrl;
    String fromEmail;
    String toEmail;

    @Before
    public void setUp() throws Exception {
        cr = new CreateReport();
        mailSender = new MailSender() {
            @Override
            public void send(SimpleMailMessage simpleMailMessage) throws MailException {

            }

            @Override
            public void send(SimpleMailMessage... simpleMailMessages) throws MailException {

            }
        };
        forecastUrl = "Information about weather forecast";
        fromEmail = "your email";
        toEmail ="person email to report weather forecast each time";
    }

    @After
    public void tearDown() throws Exception {
        cr = null;
    }

    @Test
    public void send_Fail_URL() throws Exception {
        boolean expected = false;
        boolean actual = cr.send(mailSender,forecastUrl,fromEmail,toEmail);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void send_Fail_Mail() throws Exception {
        forecastUrl = "http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml";
        boolean expected = false;
        boolean actual = cr.send(mailSender,forecastUrl,fromEmail,toEmail);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void send_Okay_Mail() throws Exception {
        forecastUrl = "http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml";
        fromEmail = "post@yr.no";
        toEmail = "post@yr.no";
        boolean expected = true;
        boolean actual = cr.send(mailSender,forecastUrl,fromEmail,toEmail);
        Assert.assertEquals(expected, actual);
    }
}