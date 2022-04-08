package it.prova.datamigration.repository.olddata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.prova.datamigration.dto.AssicuratoDTO;
import it.prova.datamigration.model.Assicurato;

public interface OldMigrationRepository extends JpaRepository<Assicurato, Integer> {

	@Query(value = "SELECT DISTINCT datifiscali_id, nome, cognome, codiceFiscale FROM datianagrafici LEFT JOIN datifiscali ON datianagrafici.datiFiscali_id = datifiscali.id", nativeQuery = true)
	List<AssicuratoDTO> findAllEager();

	@Query(value = "SELECT COUNT(datiAnagrafici_id) FROM sinistri LEFT JOIN datianagrafici ON sinistri.datiAnagrafici_id = datianagrafici.id WHERE datianagrafici.id = (SELECT DISTINCT datifiscali_id FROM datianagrafici LEFT JOIN datifiscali ON datianagrafici.datiFiscali_id = datifiscali.id WHERE datifiscali.id = ?1)", nativeQuery = true)
	int countSinistri(Long id);

}
