package no.firma.oppgave.component;

import no.firma.oppgave.helpers.CreateReport;
import no.firma.oppgave.helpers.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by p on 23/01/2017.
 */
@Component
public class WeatherComponent {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String currentTime;

    @Autowired
    private MailSender mailSender;

    @Value("${weather.forecast.for.Svalbalen}")
    private String forecastUrl;

    @Value("${send.from.email}")
    private String fromEmail;

    @Value("${send.to.email}")
    private String toEmail;

    @Scheduled(fixedRate = 1000 * 60 * 5)
    // 1 hour (1000 * 60 * 60) CreateTime.hours(1);
    // 5 minuter (1000 * 60 * 5) CreateTime.minutes(5);
    public String startSendWeatherReportEmail() {

        if(!Validation.isValidString(forecastUrl) || !Validation.isValidURL(forecastUrl)) {

            log.error("Url to fetch weather forecast from yr.no is not correct or check if you have connection to nett. \n" +
                    "Tips: See application.properties for weather.forecast.for.Svalbalen or check if you have connection to nett. \n" +
                    "Link: http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml");

            return "Url to fetch weather forecast from yr.no is not correct or check if you have connection to nett. \n" +
                    "Tips: See application.properties for weather.forecast.for.Svalbalen. \n" +
                    "Link: http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml";
        }

        if(!Validation.isValidEmailAddress(fromEmail)) {

            log.error("fromEmail is not correct. \n" +
                    "Tips: See application.properties for send.from.email.");

            return "fromEmail is not correct. \n" +
                    "Tips: See application.properties for send.from.email.";
        }

        if(!Validation.isValidEmailAddress(toEmail)) {

            log.error("toEmail is not correct. \n" +
                    "Tips: See application.properties for send.to.email.");

            return "toEmail is not correct. \n" +
                    "Tips: See application.properties for send.to.email.";
        }

        try {
            forecastUrl = URLDecoder.decode(forecastUrl, "UTF-8");

            createWeatherReportEmail(mailSender, forecastUrl, fromEmail, toEmail);

        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());

            return e.getMessage();
        }

        log.info("Started task to send weather report email from Svalbalen every hour.");

        return "Started task to send weather report email from Svalbalen every hour.";
    }

    private void createWeatherReportEmail(MailSender mailSender, String forecastUrl, String fromEmail, String toEmail) {
        currentTime = LocalDateTime.now().format(formatter);
        log.info("START - Send Weather Report at " + currentTime);
        CreateReport.send(mailSender, forecastUrl, fromEmail, toEmail);
        currentTime = LocalDateTime.now().format(formatter);
        log.info("END   - Send Weather Report at " + currentTime + "\n\n");
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setForecastUrl(String forecastUrl) {
        this.forecastUrl = forecastUrl;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }
}