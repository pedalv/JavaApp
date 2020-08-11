package no.agitec.fagaften.mellom.oppdrag.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;


/**
 *
 * You should not use Digest Authentication in modern applications because it is not considered secure.
 * The most obvious problem is that you must store your passwords in plaintext, encrypted, or an MD5 format.
 * All of these storage formats are considered insecure.
 *
 * Instead, you should store credentials using a one way adaptive password hash
 * (i.e. bCrypt, PBKDF2, SCrypt, etc) which is not supported by Digest Authentication.
 */
@Slf4j
public class CreatePassword {

    private static CharSequence cs = "myPassword";

    public static void main(String ... args) {
        createCustomDelegatingPasswordEncoder();

    }

    private static void createCustomDelegatingPasswordEncoder() {
        String idForEncode = "bcrypt";
        HashMap<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        encoders.put("noop", NoOpPasswordEncoder.getInstance()); //Not secure
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("sha256", new StandardPasswordEncoder()); //Not secure

        PasswordEncoder passwordEncoder =
                new DelegatingPasswordEncoder(idForEncode, encoders);


        createBCryptPasswordEncoder();
        createArgon2PasswordEncoder();
        createPbkdf2PasswordEncoder();
        createSCryptPasswordEncoder();

        /**
         * BCryptPasswordEncoder: myPassword => $2a$16$xcqdEpapjxJrvzbmdPaAouE.u6mINzS7.CQET7Lceujeczevr4vGq
         * Argon2PasswordEncoder: myPassword => $argon2id$v=19$m=4096,t=3,p=1$SOc7UFG129GE/3y+0NlmfA$S3+StdR44p9aJc39y7ibEujaMe4bcN63yCIzyhow9dU
         * Pbkdf2PasswordEncoder: myPassword => 2f323bad3e883e96c302e3e98a1bbd21c0e611dea8e906c1db25ae0cf5d34e912f65a98aa529d21f
         * SCryptPasswordEncoder: myPassword => $e0801$NHJs6FSXA3CySzc+lBlTddKW7EC/g1Gu4zSsEMvWWsAY6FiKGxWKW1l5t5JlNM8Bi6k8FmY1l42GUt738azWUg==$IMq/nFTcW0zoiLaB/foRSI4ord/QF4/y6CuK8dJJiSs=
         *
         * BCryptPasswordEncoder: myPassword => $2a$16$l6qipHEzQC/mntYbxV2NiOgPeTTa0iXEdM6pFwqtZ9Y/KPOLQA0ym
         * Argon2PasswordEncoder: myPassword => $argon2id$v=19$m=4096,t=3,p=1$6pZhSPwBwiPT0UMs2NJtvw$6t+70aq3jCTmgwZwwzE+OnuNzkwxfuU7fK9jLj25W5g
         * Pbkdf2PasswordEncoder: myPassword => 955e415aad11f79b184744c811ac2874d03072dde60ef5fea99bb333258d114136250321ee891115
         * SCryptPasswordEncoder: myPassword => $e0801$aqVsbegJoqy4GISynj3l0rIIRoDOnNSufhSETwNIgH7Hq5TsI5H5zKjumW+Wq36dkeHfoNtLr6N5I8Q2apfUTA==$kTmrm9eM/DQlPN/5qPx5KvfuLfzarjyC+Q8bqZPI4rc=
         */

        return;
    }

    public static String bCryptPasswordEncoder(CharSequence cs ) {
        // Create an encoder with strength 16

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode(cs.toString());
        log.info("BCryptPasswordEncoder: " + cs.toString() + " => " + result);
        return result;
    }

    private static void createBCryptPasswordEncoder() {
        // Create an encoder with strength 16

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode(cs.toString());
        log.info("BCryptPasswordEncoder: " + cs.toString() + " => " + result);
    }

    private static void createArgon2PasswordEncoder() {
        // Create an encoder with all the defaults
        Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
        String result = encoder.encode(cs.toString());
        log.info("Argon2PasswordEncoder: " + cs.toString() + " => " + result);
    }

    public static void createPbkdf2PasswordEncoder() {
        // Create an encoder with all the defaults
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        String result = encoder.encode("myPassword");
        log.info("Pbkdf2PasswordEncoder: " + cs.toString() + " => " + result);
    }

    public static void createSCryptPasswordEncoder() {
        // Create an encoder with all the defaults
        SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
        String result = encoder.encode(cs);
        log.info("SCryptPasswordEncoder: " + cs.toString() + " => " + result);
    }



}
