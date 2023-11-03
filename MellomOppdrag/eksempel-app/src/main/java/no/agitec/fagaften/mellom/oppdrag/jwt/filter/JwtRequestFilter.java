package no.agitec.fagaften.mellom.oppdrag.jwt.filter;

import no.agitec.fagaften.mellom.oppdrag.jwt.util.JwtUtil;
import no.agitec.fagaften.mellom.oppdrag.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class JwtRequestFilter extends OncePerRequestFilter {

    /**
     * https://www.baeldung.com/circular-dependencies-in-spring
     */
    @Autowired
    @Lazy
    private UserDetailsServiceImp userDetailsServiceImp;

    @Autowired
    private JwtUtil jwtUtil;


    /**
     *
     * === MimeHeaders ===
     * content-type = application/json
     * authorization = Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjAxOTE2Njk4LCJpYXQiOjE2MDE4ODA2OTh9.1zt2wZczx7naT9cx6nEFXeXMzK94N5CxaI811jFy0vM
     * user-agent = PostmanRuntime/7.26.5
     * accept =
     * postman-token = 516db340-e2a6-4913-a257-4d679585866c
     * host = localhost:8080
     * accept-encoding = gzip, deflate, br
     * connection = keep-alive
     * cookie = JSESSIONID=D03679A0EF5E6BF2B2CA14716BDB771C
     *
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        //Det finnes session for loginn skjemma
        boolean isNotAuthentication = SecurityContextHolder.getContext().getAuthentication() == null
                || SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser") ;

        if (username != null) {

            UserDetails userDetails = userDetailsServiceImp.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwt, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }

}
