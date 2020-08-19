package no.agitec.fagaften.mellom.oppdrag.repository.store;

import no.agitec.fagaften.mellom.oppdrag.domain.store.Importer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImporterRepository extends JpaRepository<Importer, Long> {
}
