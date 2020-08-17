package no.agitec.fagaften.mellom.oppdrag.repository.store;

import no.agitec.fagaften.mellom.oppdrag.store.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
