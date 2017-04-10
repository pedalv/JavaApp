package no.firma.oppgave.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by p on 04/01/2017.
 */
public class CreateReport {

    private static final Logger log = LoggerFactory.getLogger("CreateReport");

    private static SimpleMailMessage templateMessage;

    public static boolean send(MailSender mailSender, String forecastUrl, String fromEmail, String toEmail) {

        if(!Validation.isValidString(forecastUrl) || !Validation.isValidURL(forecastUrl)) {

            log.error("Url to fetch weather forecast from yr.no is not correct or check if you have connection to nett. \n" +
                    "Tips: See application.properties for weather.forecast.for.Svalbalen. \n" +
                    "Link: http://www.yr.no/sted/Norge/S%C3%B8r-Tr%C3%B8ndelag/Fr%C3%B8ya/Svalbalen/varsel_time_for_time.xml");

            return false;
        }

        try {
            forecastUrl = URLDecoder.decode(forecastUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
            return false;
        }

        int initLen = ForecastFromYr.getInitLen();
        String forecast = ForecastFromYr.fetchReport(forecastUrl);
        int forecastLen = forecast.length();

        if(forecastLen <= initLen) {

            log.error("MISSING INFORMATION TO SEND MAIL WEATHER REPORT");

            return false;
        }

        if(!Validation.isValidEmailAddress(fromEmail)) {

            log.error("fromEmail is not correct. \n" +
                    "Tips: See application.properties for send.from.email.");

            return false;
        }

        if(!Validation.isValidEmailAddress(toEmail)) {

            log.error("toEmail is not correct. \n" +
                    "Tips: See application.properties for send.to.email.");

            return false;
        }

        log.info(forecast);
        log.info(fromEmail);
        log.info(toEmail);

        templateMessage = new SimpleMailMessage();
        templateMessage.setSubject("Værmelding for Svalbalen");
        templateMessage.setFrom(fromEmail);
        templateMessage.setTo(toEmail);

        SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
        msg.setText(forecast);

        log.info("Starting Send...");
        try{
            mailSender.send(msg);
        }
        catch(MailException ex){
            log.error(ex.getMessage());
            return false;
        }
        log.info("Finished Send...");
        return true;
    }
}