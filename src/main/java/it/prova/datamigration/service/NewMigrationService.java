package it.prova.datamigration.service;

import it.prova.datamigration.dto.AssicuratoDTO;

public interface NewMigrationService {

	public void inserisciNuovoValido(AssicuratoDTO assicuratoInstance);

	public void inserisciNuovoNonValido(AssicuratoDTO assicuratoInstance);

}
