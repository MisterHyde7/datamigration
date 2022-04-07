package it.prova.datamigration.dto;

public class TransferErrorDTO {

	private Long id;
	private String codiceFiscale;
	private Long oldDbId;

	public TransferErrorDTO() {
		super();
	}

	public TransferErrorDTO(String codiceFiscale, Long oldDbId) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.oldDbId = oldDbId;
	}

	public TransferErrorDTO(Long id, String codiceFiscale, Long oldDbId) {
		super();
		this.id = id;
		this.codiceFiscale = codiceFiscale;
		this.oldDbId = oldDbId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Long getOldDbId() {
		return oldDbId;
	}

	public void setOldDbId(Long oldDbId) {
		this.oldDbId = oldDbId;
	}

}
