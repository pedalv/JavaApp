package no.insurance.repository;

import no.insurance.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by p on 22/10/2016.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
