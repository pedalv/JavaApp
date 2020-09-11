package no.agitec.fagaften.mellom.oppdrag.config;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.jwt.filter.JwtRequestFilter;
import no.agitec.fagaften.mellom.oppdrag.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * https://www.yawintutor.com/multiple-login-pages-using-spring-boot-security-with-database-authentication/
 */
@Configuration
@EnableWebSecurity
//@EnableOAuth2Client
/*
https://github.com/login/oauth/authorize?
    client_id=github-client-id&
    redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Flogin%2Foauth2%2Fcode%2Fgithub&
    response_type=code&
    scope=read%3Auser&
    state=vZdi9MQInWvJkooQAqp4prj-r_TwgBRvV0FK01P0kxI%3D
 */
//@EnableOAuth2Sso
//@EnableAuthorizationServer
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    //UserDetailsService userDetailsServiceImpl;
    UserDetailsServiceImp userDetailsServiceImpl;

    @Autowired
    DataSource dataSource;

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    /**
     * AUTHENTICATION
     *
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //#Overwriting Spring Security default authentication - way 2
        auth.inMemoryAuthentication()
                .withUser("bla")
                //.password("bla") //hashed passwords! - ENCODE
                .password(bCryptPasswordEncoder.encode("bla" ))
                .roles("USER");

        /**
         * TODO: DataBase was not created and populated
         * org.springframework.security.authentication.InternalAuthenticationServiceException:
         * PreparedStatementCallback; bad SQL grammar
         * [select username,password,enabled from users where username = ?];
         * nested exception is org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "USERS" not found; SQL statement:
         * select username,password,enabled from users where username = ? [42102-200]
         *
         * change from in mem to JDBC
         * https://docs.spring.io/spring-security/site/docs/4.0.x/reference/html/appendix-schema.html
         */
        auth.jdbcAuthentication()
                .dataSource(dataSource) //H2 //MYSQL //ORACLE //osv
                //Change to resources.database.*
                .withDefaultSchema()
                .withUser(
                        User.withUsername("user2")
                                //.password("pass")
                                .password( bCryptPasswordEncoder.encode("pass" ) )
                                .roles("USER")
                )
                .withUser(
                        User.withUsername("admin2")
                                //.password("pass")
                                .password( bCryptPasswordEncoder.encode("pass" ) )
                                .roles("ADMIN")
                );


        //logg inn ved skjemma
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);

        //TODO
        //LDAP - load the LDAP server with a data file that contains a set of users.
        //Spring Boot provides auto-configuration for an embedded server written in pure Java,
        // which is being used for this guide. The ldapAuthentication()
        // method configures things so that the user name at the login form is plugged into
        // {0} such that it searches uid={0},ou=people,dc=springframework,dc=org in the LDAP server.
        // Also, the passwordCompare() method configures the encoder and the name of the password’s attribute.
/*
        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder())
                .passwordAttribute("userPassword");
*/
    }

    /**
     * Field authenticationManager in no.agitec.fagaften.mellom.oppdrag.web.controller.rest.JwtController required a bean of type 'org.springframework.security.authentication.AuthenticationManager' that could not be found.
     *
     * The injection point has the following annotations:
     * 	- @org.springframework.beans.factory.annotation.Autowired(required=true)
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     *
     * Field bCryptPasswordEncoder in no.agitec.fagaften.mellom.oppdrag.service.UserDetailsServiceImp required a bean of type 'org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder' that could not be found.
     *
     * The injection point has the following annotations:
     * 	- @org.springframework.beans.factory.annotation.Autowired(required=true)
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public BCryptPasswordEncoder getbCryptPasswordEncoder() {
        return bCryptPasswordEncoder;
    }


    /**
     * AUTHORIZATION
     *
     * 12.1. OAuth 2.0 Login
     * Users log in to the application by using their existing account at
     * an OAuth 2.0 Provider (e.g. GitHub) or OpenID Connect 1.0 Provider (such as Google).
     * OAuth 2.0 Login implements the use cases: "Login with Google" or "Login with GitHub".
     *
     * OpenID Connect 1.0 Authentication introduces the ID Token,
     * the Authentication of an End-User by an Authorization Server when used by a Client.
     * The ID Token is represented as a JSON Web Token (JWT) and MUST be signed using JSON Web Signature (JWS).
     *
     *
     *  Cross Site Request Forgery (CSRF)
     *  https://docs.spring.io/spring-security/site/docs/current/reference/html5/#csrf
     *  Løsning: token - amount=100.00&routingNumber=1234&account=9876&_csrf=4bfd1575-3ad1-4d21-96c7-4ef2d9f86721
     *  Cross Site Scripting (XSS) - attacks are a type of injection
     *  https://owasp.org/www-community/attacks/xss/
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //System.out.println("**** configure");
        http
                //.csrf().disable()
                .httpBasic(withDefaults())
                .authorizeRequests()
                .antMatchers(
                        //"/css/**",
                        "/",
                        "/error",
                        "/jwt/authenticate",
                        "/hello", //Rem later
                        "/home", //Rem later
                        "/customer",
                        "/employee",
                        //"/partner",
                        //"/oauth2/authorization/github",
                        "/person",
                        "/kafka",
                        "/kafka/string",
                        "/kafka/string/producer",
                        "/kafka/sample1/send/foo/*",
                        "/kafka/sample1/send/foo2/*",
                        "/kafka/sample2/send/foo/*",
                        "/kafka/sample2/send/bar/*",
                        "/kafka/sample2/send/unknown/*",
                        "/kafka/sample3/send/foos/*").permitAll()
                //.antMatchers("/admin/**").hasRole("ADMIN") // "ROLE_ADMIN"
                //.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA') and hasIpAddress('192.168.1.0/24')") //"ROLE_ADMIN" and "ROLE_DBA"
                .antMatchers("/partner").hasAnyRole( "USER", "STAFF", "ADMIN" )

                //JWT
                .and()
                .sessionManagement()
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Uten session hvis det finnes bare loginn med JWT
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) //Det finnes login skjemma og social loginn

                //LOGIN FORM
                .and()
                .formLogin()
                .loginPage("/login")

                // SOCIAL MEDIA LOGIN
                // Det finnes bare GitHub for å logge innn i først gang.
                // Etter logg ut finnes mulighet for logg inn ved skjemma eller GitHub.
                // TODO: Store values in database clientId and clientSecret for allow many users
                //.and()
                //.oauth2Login()

                .permitAll()
                .and()
                .logout()
                .permitAll();

        //JWT
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
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
*/

/*
TIPS

@RequestMapping("/foo")
public String foo(@AuthenticationPrincipal User user) {
  ... // do stuff with user
}

@RequestMapping("/foo")
public String foo(Principal principal) {
  Authentication authentication = (Authentication) principal;
  User = (User) authentication.getPrincipal();
  ... // do stuff with user
}

Authentication auth = httpServletRequest.getUserPrincipal();
// assume integrated custom UserDetails called MyCustomUserDetails
// by default, typically instance of UserDetails
MyCustomUserDetails userDetails = (MyCustomUserDetails) auth.getPrincipal();
String firstName = userDetails.getFirstName();
String lastName = userDetails.getLastName();

KOTLIN
https://github.com/spring-projects/spring-security/tree/master/samples/boot/kotlin
*/

/*
=== https://docs.spring.io/spring-security/site/docs/5.3.5.BUILD-SNAPSHOT/reference/html5/#jackson
Jackson Support

ObjectMapper mapper = new ObjectMapper();
ClassLoader loader = getClass().getClassLoader();
List<Module> modules = SecurityJackson2Modules.getModules(loader);
mapper.registerModules(modules);

// ... use ObjectMapper as normally ...
SecurityContext context = new SecurityContextImpl();
// ...
String json = mapper.writeValueAsString(context);
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

/*
//TEXT password
@Bean
public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
}
 */