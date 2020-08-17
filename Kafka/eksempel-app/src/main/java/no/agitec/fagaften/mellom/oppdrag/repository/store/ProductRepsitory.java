package no.agitec.fagaften.mellom.oppdrag.repository.store;

import no.agitec.fagaften.mellom.oppdrag.store.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepsitory extends JpaRepository<Product, Long>  {
}
