package it.prova.datamigration.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.prova.datamigration.dto.AssicuratoDTO;

public interface NewMigrationRepository
		extends PagingAndSortingRepository<AssicuratoDTO, Long>, JpaSpecificationExecutor<AssicuratoDTO> {

}
