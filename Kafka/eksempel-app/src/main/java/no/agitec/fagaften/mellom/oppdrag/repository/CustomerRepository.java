package no.agitec.fagaften.mellom.oppdrag.repository;

import no.agitec.fagaften.mellom.oppdrag.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {

    List<Customer> findByName(String name);

    //Customer findById(long id);

}

/*
CrudRepository mainly provides CRUD functions: Create, Read, Update, Delete

PagingAndSortingRepository provides methods to do pagination and sorting records.

JpaRepository provides some JPA-related methods such as flushing the persistence context and deleting records in a batch.
 */