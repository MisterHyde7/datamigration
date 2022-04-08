package it.prova.datamigration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.datamigration.dto.AssicuratoDTO;
import it.prova.datamigration.repository.olddata.OldMigrationRepository;

@Service
public class OldMigrationServiceImpl implements OldMigrationService {

	@Autowired
	OldMigrationRepository repository;

	@Override
	@Transactional("oldTransactionManager")
	public List<AssicuratoDTO> caricaElementiEager() {
		return repository.findAllEager();
	}

	@Override
	@Transactional("oldTransactionManager")
	public int contaSinistri(Long id) {
		return repository.countSinistri(id);
	}

}
