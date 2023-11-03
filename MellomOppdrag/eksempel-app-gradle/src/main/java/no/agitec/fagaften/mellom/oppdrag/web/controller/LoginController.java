package no.agitec.fagaften.mellom.oppdrag.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class LoginController {

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping("/github")
    public ResponseEntity<Object> redirectToExternalUrl() throws URISyntaxException {
        //URI yahoo = new URI("http://www.yahoo.com");
        URI github = new URI("https://github.com/");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(github);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

}
