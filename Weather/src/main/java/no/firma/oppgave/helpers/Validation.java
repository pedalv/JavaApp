package no.firma.oppgave.helpers;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Optional;

/**
 * Created by p on 13/01/2017.
 */
public class Validation {

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public static boolean isValidURL(String forecastUrl) {
        boolean result = true;
        try {
            forecastUrl = URLDecoder.decode(forecastUrl, "UTF-8");
            URL url = new URL(forecastUrl);
            URLConnection conn = url.openConnection();
            conn.connect();
        } catch (MalformedURLException e) {
            result = false;
        } catch (IOException e) {
            result = false;
        }
        return result;
    }

    public static boolean isValidString(String str) {
        boolean result = true;
        String s = Optional.ofNullable(str).orElse("");
        if (s.trim().isEmpty()) {
            result = false;
        }
        return result;
    }

}
