package no.agitec.fagaften.eksempelapp.service;

import no.agitec.fagaften.eksempelapp.domain.Customer;
import no.agitec.fagaften.eksempelapp.domain.Person;
import no.agitec.fagaften.eksempelapp.repository.CustomerRepository;
import no.agitec.fagaften.eksempelapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public List<Customer> hentCustomer(){
        List<Customer> result = new ArrayList<>();
        customerRepository.findAll().forEach(result::add);
        return result;
    }

}
