package no.firma.oppgave.controllers;

import no.firma.oppgave.component.WeatherComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by p on 04/01/2017.
 */
@RestController
public class WeatherController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeatherComponent weatherComponent;

    @RequestMapping("/weather/report")
    @ResponseBody
    public String WeatherReport() {

        return weatherComponent.startSendWeatherReportEmail();

    }

    public void setWeatherComponent(WeatherComponent weatherComponent) {
        this.weatherComponent = weatherComponent;
    }
}
