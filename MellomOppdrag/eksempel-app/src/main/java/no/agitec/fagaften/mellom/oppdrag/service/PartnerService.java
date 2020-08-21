package no.agitec.fagaften.mellom.oppdrag.service;

import no.agitec.fagaften.mellom.oppdrag.domain.Partner;
import no.agitec.fagaften.mellom.oppdrag.repository.PartnerRepository;
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
