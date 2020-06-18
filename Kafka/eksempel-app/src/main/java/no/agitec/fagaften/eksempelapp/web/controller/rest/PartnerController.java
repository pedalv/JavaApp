package no.agitec.fagaften.eksempelapp.web.controller.rest;

import no.agitec.fagaften.eksempelapp.service.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
@RequestMapping("/api/partner")
public class PartnerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @ModelAttribute
    public void addPartnerModel(Model model) {
        model.addAttribute("partners", partnerService.hentCustomer());
        model.addAttribute("name", "Decisive AS");
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping()
    public String mainPartner() {
        return "partner";
    }

}
