package no.agitec.fagaften.mellom.oppdrag.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/oauth2/social")
public class OAuth2Controller {

    // GitHub
    // Facebook
    // LinkedIn
    // Google
    @GetMapping("/message")
    public String message(Principal principal)  {
        String name = "Anonymous";
        if(principal != null) {
            name = principal.getName();
        }
        return "Hi '" + name + "' welcome to ExampleAPP";
    }

    @GetMapping("user")
    @ResponseBody
    public Principal user(Principal principal)  {
        return principal;
    }

}
