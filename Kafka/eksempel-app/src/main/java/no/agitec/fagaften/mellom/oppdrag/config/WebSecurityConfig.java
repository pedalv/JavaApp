package no.agitec.fagaften.mellom.oppdrag.config;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    //UserDetailsService userDetailsServiceImpl;
    UserDetailsServiceImp userDetailsServiceImpl;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
    }

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

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}


/*
=== https://github.com/spring-guides/top-spring-security-architecture

Authentication and Access Control: authentication (who are you?) and authorization (what are you allowed to do?)
- Authentication
- Customizing Authentication Managers
- Authorization or Access Control
Web Security: Client -> Filter -> Filter -> Filter -> Servlet
- Creating and Customizing Filter Chains
- Request Matching for Dispatch and Authorization
- Combining Application Security Rules with Actuator Rules
Method Security
Working with Threads
- Processing Secure Methods Asynchronously



1. SecurityContextHolder
1.1 SecurityContext
1.2 Authentication
1.2.1 Principal - Credentials - Authorities

SecurityContextHolder: authenticated -> SecurityContext
Authentication: GrantedAuthority

1. AuthenticationManager
1.1 ProviderManager
1.1.1 AuthenticationProvider

AuthenticationManager(Authentication): the API that defines how Spring Security's Filters perform authentication
ProviderManager: the most commom implementation of AuthenticationManager
AuthenticationProvider: used by ProviderManager to perform a specific type of authentication

Request Credentials with AuthenticationEntryPoint: used for requesting credentials from a client

AbstractAuthenticationProcessingFilter - a base Fikter used for authentication

1. AbstractAuthenticationProcessingFilter
2. Authentication - AuthenticationManager
3 Failure
- SecurityContextHolder
- RememberMeServices
- Authenication FailureHandler
4 Success
- SessionAuthenticationStrategy
- SecurityContextHolder
- RememberMeServices
- ApplicationEventPublisher
- AuthenticationSuccessHandler













TODO
Bean - BCryptPasswordEncoder
Config - AuthenticationManagerBuilder
 */


/*
    //Before
    //WebSecurityConfigurerAdapter -> userDetailsService() === Bean Override

    //Now
    //class UserDetailsServiceImp implements UserDetailsService -> loadUserByUsername() === Override


    //Not user anymore
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
 */