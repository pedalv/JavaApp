package no.agitec.fagaften.eksempelapp.service;

import no.agitec.fagaften.eksempelapp.domain.Partner;
import no.agitec.fagaften.eksempelapp.domain.Person;
import no.agitec.fagaften.eksempelapp.repository.CustomerRepository;
import no.agitec.fagaften.eksempelapp.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartnerService {

    private final PartnerRepository partnerRepository;

    @Autowired
    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Transactional
    public List<Partner> hentCustomer(){
        List<Partner> result = new ArrayList<>();
        partnerRepository.findAll().forEach(result::add);
        return result;
    }

}
