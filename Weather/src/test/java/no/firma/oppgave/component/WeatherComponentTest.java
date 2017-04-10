package no.firma.oppgave.component;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by p on 23/01/2017.
 */
public class WeatherComponentTest {

    private WeatherComponent weatherComponent;

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Before
    public void setUp() throws Exception {
        weatherComponent = new WeatherComponent();

    }

    @After
    public void tearDown() throws Exception {
        weatherComponent = null;

    }

    @Test
    public void weatherReport_Fail() throws Exception {
        String expected = "Url to fetch weather forecast from yr.no is not correct or check if you have connection to nett. \n" +
                "Tips: See application.properties for weather.forecast.for.Svalbalen. \n" +
                "Link: http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml";
        String actual = weatherComponent.startSendWeatherReportEmail();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void weatherReport_Emails_Fail() throws Exception {
        weatherComponent.setForecastUrl("http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml");
        exception.expect(NullPointerException.class);
        weatherComponent.startSendWeatherReportEmail();
    }

    @Test
    public void weatherReportSucess() throws Exception {
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

        String expected = "Started task to send weather report email from Svalbalen every hour.";
        String actual = weatherComponent.startSendWeatherReportEmail();
        Assert.assertEquals(expected, actual);
    }

}