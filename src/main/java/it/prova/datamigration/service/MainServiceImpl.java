package it.prova.datamigration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.prova.datamigration.dto.AssicuratoDTO;

public class MainServiceImpl implements MainService {

	@Autowired
	NewMigrationServiceImpl newMigrationServiceImpl;

	@Autowired
	OldMigrationServiceImpl oldMigrationServiceImpl;

	@Override
	public void transfertData() {

		List<AssicuratoDTO> assicuratiDaVecchioDB = oldMigrationServiceImpl.caricaElementiEager();

		for (AssicuratoDTO assicuratoDTOItem : assicuratiDaVecchioDB) {
			if (isValidInput(assicuratoDTOItem)) {
				newMigrationServiceImpl.inserisciNuovoValido(assicuratoDTOItem);
			}
			newMigrationServiceImpl.inserisciNuovoNonValido(assicuratoDTOItem);
		}
		
	}

	private static boolean isValidInput(AssicuratoDTO assicuratoDTO) {

		if (assicuratoDTO.getCodiceFiscale().length() != 16 || assicuratoDTO.getDataNascita() == null)
			return false;

		return true;
	}

}
