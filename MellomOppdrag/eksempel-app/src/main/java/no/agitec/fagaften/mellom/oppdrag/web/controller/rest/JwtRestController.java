package no.agitec.fagaften.mellom.oppdrag.web.controller.rest;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.jwt.model.AuthenticationRequest;
import no.agitec.fagaften.mellom.oppdrag.jwt.model.AuthenticationResponse;
import no.agitec.fagaften.mellom.oppdrag.jwt.util.JwtUtil;
import no.agitec.fagaften.mellom.oppdrag.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
@Slf4j
public class JwtRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping(path = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest ) throws Exception {

        try {
            authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    authenticationRequest.getUsername(),
                                    authenticationRequest.getPassword()
                            )
                    );
        } catch (BadCredentialsException e) {
            log.error(e.getMessage());
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsServiceImp.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
        // "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTk5NTg3NjczLCJpYXQiOjE1OTk1NTE2NzN9.vv7Ce4Sxi0kUZQTn6CDG7lPyUfaKSZN9AuEZzhWFNro"
        // "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjAxOTE2Njk4LCJpYXQiOjE2MDE4ODA2OTh9.1zt2wZczx7naT9cx6nEFXeXMzK94N5CxaI811jFy0vM"
    }

}
