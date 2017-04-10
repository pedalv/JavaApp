package no.firma.oppgave.api;

import no.firma.oppgave.helpers.ForecastFromYr;
import no.firma.oppgave.model.Weather;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;

/**
 * Created by p on 27/01/2017.
 */
public class WeatherApiTest {

    private WeatherApi weatherRest;

    @Before
    public void setUp() throws Exception {
        weatherRest = new WeatherApi();
        weatherRest.setForecastUrl("hfjdsfjs");


    }

    @After
    public void tearDown() throws Exception {
        weatherRest = null;
    }

    @Test
    public void weatherJson_Fail() throws Exception {
        Weather weather = weatherRest.WeatherJson();

        Assert.assertTrue(weather == null);
    }

    @Test
    public void weatherJson_Okay() throws Exception {
        weatherRest.setForecastUrl("http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml");
        Weather weather = weatherRest.WeatherJson();
        Assert.assertNotNull(weather);

        Assert.assertNotNull(weather.getTimeFrom());
        Assert.assertNotNull(weather.getTimeTo());
        Assert.assertNotNull(weather.getSymbolNumber());
        Assert.assertNotNull(weather.getSymbolName());
        Assert.assertNotNull(weather.getPrecipitationValue());
        Assert.assertNotNull(weather.getWindDirectionName());
        Assert.assertNotNull(weather.getWindSpeedMps());
        Assert.assertNotNull(weather.getWindSpeedName());
        Assert.assertNotNull(weather.getTemperatureUnit());
        Assert.assertNotNull(weather.getTemperatureValue());
        Assert.assertNotNull(weather.getPressureUnit());
        Assert.assertNotNull(weather.getPressureValue());
    }
}