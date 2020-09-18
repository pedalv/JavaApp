package no.agitec.fagaften.mellom.oppdrag.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/social")
public class SocialController {

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

    /**
     * The /user Endpoint (front-end): https://spring.io/guides/tutorials/spring-boot-oauth2/
     * @param principal
     * @return
     */
    @GetMapping("/user2")
    public Map<String, Object> user2(@AuthenticationPrincipal OAuth2User principal) {
        //Map<String, Object> users = Collections.singletonMap("name", principal.getAttribute("name"));
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

}
