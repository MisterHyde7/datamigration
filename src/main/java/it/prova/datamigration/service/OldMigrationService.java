package it.prova.datamigration.service;

import java.util.List;

import it.prova.datamigration.dto.AssicuratoDTO;

public interface OldMigrationService {

	public List<AssicuratoDTO> caricaElementiEager();

	public int contaSinistri(Long id);

}
