package no.agitec.fagaften.mellom.oppdrag.web.controller;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.mellom.oppdrag.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/partner")
@Slf4j
public class PartnerController {

    private final PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @ModelAttribute
    public void addPartnerModel(Model model) {
        log.info("== addPartnerModel");
        model.addAttribute("partners", partnerService.hentCustomer());
        model.addAttribute("name", "Decisive AS");
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping()
    @Secured("ROLE_USER")
    public String mainPartner() {
        return "partner";
    }

}
