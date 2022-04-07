package it.prova.datamigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.prova.datamigration.dto.AssicuratoDTO;

public interface OldMigrationRepository
		extends PagingAndSortingRepository<AssicuratoDTO, Long>, JpaSpecificationExecutor<AssicuratoDTO> {

	@Query("SELECT DISTINCT datifiscali_id, nome, cognome, codiceFiscale FROM datianagrafici LEFT JOIN datifiscali ON datianagrafici.datiFiscali_id = datifiscali.id;")
	List<AssicuratoDTO> findAllEager();

	@Query("SELECT COUNT(datiAnagrafici_id) FROM sinistri LEFT JOIN datianagrafici ON sinistri.datiAnagrafici_id = datianagrafici.id WHERE datianagrafici.id = (SELECT DISTINCT datifiscali_id FROM datianagrafici LEFT JOIN datifiscali ON datianagrafici.datiFiscali_id = datifiscali.id WHERE datifiscali.id = ?1);")
	int countSinistri(Long id);

}
