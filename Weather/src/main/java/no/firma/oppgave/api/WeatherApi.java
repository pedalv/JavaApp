package no.firma.oppgave.api;

import no.firma.oppgave.helpers.ForecastFromYr;
import no.firma.oppgave.helpers.Validation;
import no.firma.oppgave.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by p on 27/01/2017.
 */
@RestController
public class WeatherApi {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${weather.forecast.for.Svalbalen}")
    private String forecastUrl;

    @RequestMapping("/api/weather")
    @ResponseBody
    public Weather WeatherJson() {

        if(!Validation.isValidString(forecastUrl) || !Validation.isValidURL(forecastUrl)) {

            log.error("Url to fetch weather forecast from yr.no is not correct or check if you have connection to nett. \n" +
                    "Tips: See application.properties for weather.forecast.for.Svalbalen. \n" +
                    "Link: http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml");

            return null;
        }

        ForecastFromYr.fetchReport(forecastUrl);
        Weather weather = ForecastFromYr.getWeather();

        return new Weather(weather.getTimeFrom(), weather.getTimeTo(),
                weather.getSymbolNumber(), weather.getSymbolName(),
                weather.getPrecipitationValue(),
                weather.getWindDirectionName(), weather.getWindSpeedMps(), weather.getWindSpeedName(),
                weather.getTemperatureValue(), weather.getTemperatureUnit(),
                weather.getPressureValue(), weather.getPressureUnit());

    }

    public void setForecastUrl(String forecastUrl) {
        this.forecastUrl = forecastUrl;
    }

}
