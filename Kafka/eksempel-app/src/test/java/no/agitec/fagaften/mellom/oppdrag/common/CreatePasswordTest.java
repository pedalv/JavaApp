package no.agitec.fagaften.mellom.oppdrag.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import static org.junit.Assert.*;

@Slf4j
public class CreatePasswordTest {

    private CharSequence cs = "myPassword";

    @Test
    public void createBCryptPasswordEncoder() {
        // Create an encoder with strength 16

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode(cs.toString());
        assertTrue(encoder.matches(cs.toString(), result));

        log.info("BCryptPasswordEncoder: " + cs.toString() + " => " + result);
    }

    @Test
    public void createArgon2PasswordEncoder() {
        // Create an encoder with all the defaults
        Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
        String result = encoder.encode(cs.toString());
        assertTrue(encoder.matches(cs.toString(), result));

        log.info("BCryptPasswordEncoder: " + cs.toString() + " => " + result);
    }

    @Test
    public void createPbkdf2PasswordEncoder() {
        // Create an encoder with all the defaults
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        String result = encoder.encode("myPassword");
        assertTrue(encoder.matches(cs.toString(), result));

        log.info("BCryptPasswordEncoder: " + cs.toString() + " => " + result);
    }

    @Test
    public void createSCryptPasswordEncoder() {
        // Create an encoder with all the defaults
        SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
        String result = encoder.encode(cs);
        assertTrue(encoder.matches(cs.toString(), result));

        log.info("BCryptPasswordEncoder: " + cs.toString() + " => " + result);
    }

}