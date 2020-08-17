package no.agitec.fagaften.mellom.oppdrag.repository.store;

import no.agitec.fagaften.mellom.oppdrag.store.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository  extends JpaRepository<Company, Long> {

}
