package no.firma.oppgave.helpers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by p on 13/01/2017.
 */
public class ForecastFromYrTest {

    private String url;
    private int initLen;

    @Before
    public void setUp() throws Exception {
        url = "http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml";
        initLen = ForecastFromYr.getInitLen();
        ForecastFromYr.fetchReport(url);
    }

    @Test
    public void fetchReport() throws Exception {
        Assert.assertNotNull(ForecastFromYr.getWeather().getTimeFrom());
        Assert.assertNotNull(ForecastFromYr.getWeather().getTimeTo());
        Assert.assertNotNull(ForecastFromYr.getWeather().getSymbolNumber());
        Assert.assertNotNull(ForecastFromYr.getWeather().getSymbolName());
        Assert.assertNotNull(ForecastFromYr.getWeather().getPrecipitationValue());
        Assert.assertNotNull(ForecastFromYr.getWeather().getWindDirectionName());
        Assert.assertNotNull(ForecastFromYr.getWeather().getWindSpeedMps());
        Assert.assertNotNull(ForecastFromYr.getWeather().getWindSpeedName());
        Assert.assertNotNull(ForecastFromYr.getWeather().getTemperatureUnit());
        Assert.assertNotNull(ForecastFromYr.getWeather().getTemperatureValue());
        Assert.assertNotNull(ForecastFromYr.getWeather().getPressureUnit());
        Assert.assertNotNull(ForecastFromYr.getWeather().getPressureValue());
    }

    @Test
    public void createForecastReportFile() throws Exception {
        String actual = ForecastFromYr.createForecastReport();
        int lenActual = actual.length();
        Assert.assertNotNull(ForecastFromYr.createForecastReport());
        boolean isBiggerThan = lenActual > initLen;
        Assert.assertTrue(isBiggerThan);
    }

}