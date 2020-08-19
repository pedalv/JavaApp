package no.agitec.fagaften.mellom.oppdrag.repository.store;

import no.agitec.fagaften.mellom.oppdrag.domain.store.WarehouseProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseProductInforRepository extends JpaRepository<WarehouseProductInfo, Long>  {
}
