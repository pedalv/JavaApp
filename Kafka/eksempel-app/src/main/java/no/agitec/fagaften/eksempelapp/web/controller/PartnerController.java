package no.agitec.fagaften.eksempelapp.web.controller;

import lombok.extern.slf4j.Slf4j;
import no.agitec.fagaften.eksempelapp.service.PartnerService;
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
    public String mainPartner() {
        return "partner";
    }

}
