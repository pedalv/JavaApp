package no.agitec.fagaften.mellom.oppdrag.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.Base64;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
public class CreatePasswordTest {

    private CharSequence cs = "myPassword";

    @Test
    public void createBCryptPasswordEncoderSalt() {
        // Create an encoder with strength 16

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode(cs.toString());
        assertTrue(encoder.matches(cs.toString(), result));

        log.info("BCryptPasswordEncoder: " + cs.toString() + " => " + result);
        //BCryptPasswordEncoder: myPassword => $2a$16$D47FJW685TKGLQAm4tb72eg3ugXd1g7/KvrMYalCntNBK3KSmX1f2
        //BCryptPasswordEncoder: myPassword => $2a$16$GGCCGT1FOQy1SnDHcz0NXuDBszTdKqZGwynrt9sneuHJfMeCAI6Xi
        //BCryptPasswordEncoder: myPassword => $2a$16$S7ryPgyRf6EHo5MBCGgkq.aJIKa348dXtr4WmxoxefK5OfR9RyNd2
    }

    @Test
    public void createArgon2PasswordEncoderSalt() {
        // Create an encoder with all the defaults
        Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();
        String result = encoder.encode(cs.toString());
        assertTrue(encoder.matches(cs.toString(), result));

        log.info("Argon2PasswordEncoder: " + cs.toString() + " => " + result);
        //Argon2PasswordEncoder: myPassword => $argon2id$v=19$m=4096,t=3,p=1$5XBsAvPCTuooFbsx8u3Jow$ZYUbNgU2/pgsOEU7/rRibPOoFF0JKRZ4zZFkzeJjEC4
        //Argon2PasswordEncoder: myPassword => $argon2id$v=19$m=4096,t=3,p=1$ZLGq7V/8tUbDumqEKDDqLA$65HP29Gn+zHCZp0CI0q4eZg4bNgt0MikwX6gkBBVXDc
        //Argon2PasswordEncoder: myPassword => $argon2id$v=19$m=4096,t=3,p=1$UFu7FuMiU1FotcMOyDbiuw$cT8r7jL1zzu+JutRRvxM5msJHWBOo7Z5SQujNJAqNsQ
    }

    @Test
    public void createPbkdf2PasswordEncoderSalt() {
        // Create an encoder with all the defaults
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder();
        String result = encoder.encode("myPassword");
        assertTrue(encoder.matches(cs.toString(), result));

        log.info("Pbkdf2PasswordEncoder: " + cs.toString() + " => " + result);
        //Pbkdf2PasswordEncoder: myPassword => 877063c1cdd7c4ef9620f8c0d345568b1c41fca7473d65a5fe28f09608c9844bdb7905606bfd9df3
        //Pbkdf2PasswordEncoder: myPassword => fdaedfdc0da137ad327546f3e60d561f50e45da669d707876cd7ff10d120750c0a7b66a9f712ef22
        //Pbkdf2PasswordEncoder: myPassword => 711a71c67b67764df5311d84edae9443c06b6f4b58ca6ee50a0ec2a8cb4aaa2a8cc0ee11bc3c3657
    }

    @Test
    public void createSCryptPasswordEncoderSalt() {
        // Create an encoder with all the defaults
        SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
        String result = encoder.encode(cs);
        assertTrue(encoder.matches(cs.toString(), result));

        log.info("SCryptPasswordEncoder: " + cs.toString() + " => " + result);
        //SCryptPasswordEncoder: myPassword => $e0801$p/wb5zL7uzUeCyBvCTWYkr0z7wczVsn7IYk9lZFQDFQqOWYRTAXPFSQ+oRELFjaBDH0oz2etO3BbcFsSrHF4PA==$KqC/5USb9m8H/eGc08lsOjEDOlu+RjUNlC7d3kD3J0E=
        //SCryptPasswordEncoder: myPassword => $e0801$ag9fN6MMkL1494bVmAix2Y9rWDMbpy2l1yHrK0iJy2dxF85tMO+bQwTrhiGWZZdfdVPGm2deJml1GJGic977oQ==$qvLU7V9xq5rhdom9dBRHET3wiJXx+dXHaXNgDI1+zBA=
        //SCryptPasswordEncoder: myPassword => $e0801$NyqI1/IsA8TaezH0SquA3idpP/S/yHzzHH1pFNF7/ZTkXu9T+fV3IsF7lXql2yEcvDNv0XZBZaLyXvkMqCcj+w==$P5TNo2Hw15AKFLjqtCl4NYDDL56SWzz85uKBWXeaqYc=
    }

    @Test
    public void createBase64StrNoSalt() {
        //Encode
        String plainTextPassword = "password";
        String encodedPassword = "cGFzc3dvcmQ=";
        String encodedString = Base64.getEncoder().encodeToString(plainTextPassword.getBytes());
        assertEquals(encodedPassword, encodedString);

        //Decoded
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        assertEquals(plainTextPassword, decodedString);

        log.info("originalInput: " + plainTextPassword + ", encodedString: " + encodedString + ", decodedString: " +decodedString);
        //originalInput: password, encodedString: cGFzc3dvcmQ=, decodedString: password
        //originalInput: password, encodedString: cGFzc3dvcmQ=, decodedString: password
        //originalInput: password, encodedString: cGFzc3dvcmQ=, decodedString: password
    }

    @Test
    public void create_BytesEncryptor_TextEncryptor() {
        CharSequence password = "password";
        CharSequence salt = "salt";

        //20.2.1. BytesEncrypto
        //BytesEncryptor be = Encryptors.stronger("password", "salt");
        //Exception in thread "main" java.lang.IllgalArgumentException: Detected a Non-hex character at 1 or 2 position

        //20.2.2. TextEncryptor
        //TextEncryptor te = Encryptors.text("password", "salt");
        //Encryptors.queryableText("password", "salt");
        //Exception in thread "main" java.lang.IllgalArgumentException: Detected a Non-hex character at 1 or 2 position
    }

    @Test
    public void create_BytesKeyGeneratorSalt() {

        //20.3.1. BytesKeyGenerator
        BytesKeyGenerator generator = KeyGenerators.secureRandom();
        byte[] key = generator.generateKey();

        BytesKeyGenerator bkg = KeyGenerators.secureRandom(16);

        BytesKeyGenerator bkgs = KeyGenerators.shared(16); //returns the same key on every invocation

        log.info("20.3.1. BytesKeyGenerator === key: " + key + ", BytesKeyGenerator: " + bkg.generateKey() + ", BytesKeyGenerator shared: " + bkgs.generateKey());
        //20.3.1. BytesKeyGenerator === key: [B@365c30cc, BytesKeyGenerator: [B@701fc37a, BytesKeyGenerator shared: [B@4148db48
        //20.3.1. BytesKeyGenerator === key: [B@49c43f4e, BytesKeyGenerator: [B@290dbf45, BytesKeyGenerator shared: [B@12028586

    }

    @Test
    public void create_StringKeyGeneratorSalt() {
        //20.3.2. StringKeyGenerator
        //Salt
        StringKeyGenerator skg = KeyGenerators.string();

        log.info("20.3.2. StringKeyGenerator === StringKeyGenerator: " + skg.generateKey());
        //20.3.2. StringKeyGenerator === StringKeyGenerator: d862bed878ca3da8
        //20.3.2. StringKeyGenerator === StringKeyGenerator: 31947ea446260360
        //20.3.2. StringKeyGenerator === StringKeyGenerator: 0d577b78fc08d0c5
    }

    /**
     *         public interface PasswordEncoder {
     *             String encode(String rawPassword);
     *
     *             boolean matches(String rawPassword, String encodedPassword);
     *         }
     */
    @Test
    public void create_BCryptPasswordEncoder_Pbkdf2PasswordEncoderSalt() {
        //20.4. Password Encoding

        // Create an encoder with strength 16
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode("myPassword");
        assertTrue(encoder.matches("myPassword", result));

        log.info("20.4. Password Encoding === BCryptPasswordEncoder: " + encoder + ", result(encode): " + result);
        //20.4. Password Encoding === BCryptPasswordEncoder: org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder@525b461a, result(encode): $2a$16$OktXKB3Qsu.0.q0vaPtnAuhMj9lPWTjfHaK2gD6xSXDacAATZc6H.
        //20.4. Password Encoding === BCryptPasswordEncoder: org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder@72a7c7e0, result(encode): $2a$16$z9loMWpUcauzwJTOnorhMeiBrKuUSiYVnsuSYvQ62ilTC/JGrXE.G

        // Create an encoder with all the defaults
        Pbkdf2PasswordEncoder encoder2 = new Pbkdf2PasswordEncoder();
        String result2 = encoder2.encode("myPassword");
        assertTrue(encoder2.matches("myPassword", result2));

        log.info("20.4.  Pbkdf2PasswordEncoder: " + encoder2 + ", result(encode): " + result2);
        //20.4.  Pbkdf2PasswordEncoder: org.springframework.security.crypto.password.Pbkdf2PasswordEncoder@475e586c, result(encode): 511984324ca8d53ea91f1a7929c525a5c18c773c819e77a34b6772be2ccd754cc6baa9cdefd3db97
        //20.4.  Pbkdf2PasswordEncoder: org.springframework.security.crypto.password.Pbkdf2PasswordEncoder@130161f7, result(encode): 8a6df68426a903d4e9229bd104858740f9590e7079919626be3c2d2f47f191ac779b4c528bfb2850

    }


}