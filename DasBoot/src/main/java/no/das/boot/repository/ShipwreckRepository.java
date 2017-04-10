package no.das.boot.repository;

import no.das.boot.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by p on 13/09/2016.
 */
public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
