package no.firma.oppgave.controllers;

import no.firma.oppgave.component.WeatherComponent;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.TestPropertySource;

/**
 * Created by p on 04/01/2017.
 */
@TestPropertySource(locations = "classpath:test.properties")
public class WeatherControllerTest {

    private WeatherController weatherController;
    private WeatherComponent weatherComponent;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        weatherController = new WeatherController();

        weatherComponent = new WeatherComponent();
        weatherComponent.setForecastUrl("http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml");
        weatherComponent.setFromEmail("alves.pedro0@gmail.com");
        weatherComponent.setToEmail("alvespedro@hotmai.com");
        weatherComponent.setMailSender(new MailSender() {
            @Override
            public void send(SimpleMailMessage simpleMailMessage) throws MailException {

            }

            @Override
            public void send(SimpleMailMessage... simpleMailMessages) throws MailException {

            }
        });

    }

    @After
    public void tearDown() throws Exception {
        weatherController = null;
    }

    @Test
    public void weatherReportFail() throws Exception {
        exception.expect(NullPointerException.class);
        weatherController.WeatherReport();
    }

    @Test
    public void weatherReportSucess() throws Exception {
        weatherController.setWeatherComponent(weatherComponent);
        String expected = "Started task to send weather report email from Svalbalen every hour.";
        String actual = weatherController.WeatherReport();
        Assert.assertEquals(expected, actual);
    }
}