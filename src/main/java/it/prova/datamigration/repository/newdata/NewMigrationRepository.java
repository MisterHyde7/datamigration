package it.prova.datamigration.repository.newdata;

import org.springframework.data.jpa.repository.JpaRepository;

import it.prova.datamigration.dto.AssicuratoDTO;
import it.prova.datamigration.model.Assicurato;

public interface NewMigrationRepository extends JpaRepository<Assicurato, Integer> {

	void save(AssicuratoDTO assicuratoInstance);

}
