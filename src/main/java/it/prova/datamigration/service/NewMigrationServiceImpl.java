package it.prova.datamigration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.datamigration.dto.AssicuratoDTO;
import it.prova.datamigration.dto.TransferErrorDTO;
import it.prova.datamigration.repository.newdata.NewMigrationRepository;
import it.prova.datamigration.repository.olddata.OldMigrationRepository;

@Service
public class NewMigrationServiceImpl implements NewMigrationService {

	@Autowired
	NewMigrationRepository repository;
	
	@Autowired
	OldMigrationRepository oldRepository;

	@Override
	@Transactional("newTransactionManager")
	public void inserisciNuovoValido(AssicuratoDTO assicuratoInstance) {
		
		assicuratoInstance.setNumeroSinistri(oldRepository.countSinistri(assicuratoInstance.getId()));
		repository.save(assicuratoInstance);
		
	}

	@Override
	@Transactional("newTransactionManager")
	public void inserisciNuovoNonValido(AssicuratoDTO assicuratoInstance) {

		TransferErrorDTO errorData = new TransferErrorDTO();

		errorData.setCodiceFiscale(assicuratoInstance.getCodiceFiscale());
		errorData.setOldDbId(assicuratoInstance.getId());

		repository.save(assicuratoInstance);
		
	}

}
