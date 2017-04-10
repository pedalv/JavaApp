package no.firma.oppgave.helpers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by p on 14/01/2017.
 */
public class ForecastFromYrFileTest {

    private String pathFile;
    private int initLen;

    @Before
    public void setUp() throws Exception {
        pathFile = "src/test/resources/forecast.xml";
        initLen = ForecastFromYr.getInitLen();
        ForecastFromYr.fetchReportTest(pathFile);
    }

    @Test
    public void fetchReportFile() throws Exception {
        String timeFrom = "2017-01-13 18:00:00";
        Assert.assertEquals(timeFrom, ForecastFromYr.getWeather().getTimeFrom());
        String timeTo = "2017-01-13 19:00:00";
        Assert.assertEquals(timeTo, ForecastFromYr.getWeather().getTimeTo());
        String symbolNumber = "4";
        Assert.assertEquals(symbolNumber, ForecastFromYr.getWeather().getSymbolNumber());
        String symbolName = "Skyet";
        Assert.assertEquals(symbolName, ForecastFromYr.getWeather().getSymbolName());
        String precipitationValue = "0";
        Assert.assertEquals(precipitationValue, ForecastFromYr.getWeather().getPrecipitationValue());
        String windDirectionName = "Nord-nordvest";
        Assert.assertEquals(windDirectionName, ForecastFromYr.getWeather().getWindDirectionName());
        String windSpeedMps = "13.8";
        Assert.assertEquals(windSpeedMps, ForecastFromYr.getWeather().getWindSpeedMps());
        String windSpeedName = "Liten kuling";
        Assert.assertEquals(windSpeedName, ForecastFromYr.getWeather().getWindSpeedName());
        String temperatureUnit = "celsius";
        Assert.assertEquals(temperatureUnit, ForecastFromYr.getWeather().getTemperatureUnit());
        String temperatureValue = "4";
        Assert.assertEquals(temperatureValue, ForecastFromYr.getWeather().getTemperatureValue());
        String pressureUnit = "hPa";
        Assert.assertEquals(pressureUnit, ForecastFromYr.getWeather().getPressureUnit());
        String pressureValue = "990.3";
        Assert.assertEquals(pressureValue, ForecastFromYr.getWeather().getPressureValue());
    }

    @Test
    public void createForecastReportFile() throws Exception {
        String expected = "Vær fra 2017-01-13 18:00:00 til 2017-01-13 19:00:00 \n" +
                " Nivå 4 - Skyet \n" +
                " Regn: 0 \n" +
                " Vind kommer fra Nord-nordvest med 13.8mps - Liten kuling \n" +
                " Temperature: 4 celsius \n" +
                " Trykk: 990.3 hPa";
        String actual = ForecastFromYr.createForecastReport();
        int lenActual = actual.length();
        Assert.assertNotNull(ForecastFromYr.createForecastReport());
        Assert.assertEquals(expected,actual);
        boolean isBiggerThan = lenActual > initLen;
        Assert.assertTrue(isBiggerThan);
    }

}
