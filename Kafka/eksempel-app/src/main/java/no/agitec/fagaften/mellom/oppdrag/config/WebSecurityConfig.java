package no.agitec.fagaften.mellom.oppdrag.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 12.1. OAuth 2.0 Login
     * Users log in to the application by using their existing account at
     * an OAuth 2.0 Provider (e.g. GitHub) or OpenID Connect 1.0 Provider (such as Google).
     * OAuth 2.0 Login implements the use cases: "Login with Google" or "Login with GitHub".
     *
     * OpenID Connect 1.0 Authentication introduces the ID Token,
     * the Authentication of an End-User by an Authorization Server when used by a Client.
     * The ID Token is represented as a JSON Web Token (JWT) and MUST be signed using JSON Web Signature (JWS).
     *
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //System.out.println("**** configure");
        http
                .httpBasic(withDefaults())
                .authorizeRequests()
                .antMatchers(
                        //"/css/**",
                        "/",
                        "/home",
                        "/hello",
                        "/greeting",
                        "/person",
                        //"/partner",
                        "/customer",
                        "/employee",
                        "/kafka/sample1/send/foo/*",
                        "/kafka/sample1/send/foo2/*",
                        "/kafka/sample2/send/foo/*",
                        "/kafka/sample2/send/bar/*",
                        "/kafka/sample2/send/unknown/*",
                        "/kafka/sample3/send/foos/*",
                        "/javainuse-kafka/producer").permitAll()
                //.antMatchers("/admin/**").hasRole("ADMIN") // "ROLE_ADMIN"
                //.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA') and hasIpAddress('192.168.1.0/24')") //"ROLE_ADMIN" and "ROLE_DBA"
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                //.failureUrl("/login-error")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    /**
     * ROLE_ADMIN ⇒ ROLE_STAFF ⇒ ROLE_USER ⇒ ROLE_GUEST.
     * A user who is authenticated with ROLE_ADMIN, will behave as if they have all four roles
     *
     * @return
     */
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //System.out.println("**** userDetailsService");
        //Spring Security, OAuth2 Clinet, OAuth2 Resource Server, Apring LDAP, Okta

        UserDetails user =
                User.withDefaultPasswordEncoder()
                        //User.builder()
                        .username("user")
                        .password("password")
                        //.password(CreatePassword.bCryptPasswordEncoder("password"))
                        //BCryptPasswordEncoder: password => $2a$16$ahqFCpOXttJlTd9cq8of6uc7tr/Ak8kcDqOfDY/W.cPxOUL1Cfl9K
                        .roles("USER", "pe", "dro")
                        .build();

        log.info(user.toString());
        //Username: user; Password: [PROTECTED]; Enabled: true; AccountNonExpired: true; credentialsNonExpired: true; AccountNonLocked: true; Granted Authorities: ROLE_USER,ROLE_dro,ROLE_pe

        UserDetails admin =
                User.withDefaultPasswordEncoder()
                //User.builder()
                        .username("admin")
                        .password("password")
                        .roles("USER", "ADMIN")
                        .build();

        log.info(admin.toString());
        //Username: admin; Password: [PROTECTED]; Enabled: true; AccountNonExpired: true; credentialsNonExpired: true; AccountNonLocked: true; Granted Authorities: ROLE_ADMIN,ROLE_USER

        //NAV accout with many users:
        // https://www.yawintutor.com/multiple-login-pages-using-spring-boot-security-with-database-authentication/
        return new InMemoryUserDetailsManager(user, admin);
        //return new InMemoryUserDetailsManager(user);
    }

}
