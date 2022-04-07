package it.prova.datamigration.dto;

import java.util.Date;

public class AssicuratoDTO {

	private Long id;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String codiceFiscale;
	private int numeroSinistri;

	public AssicuratoDTO() {
		super();
	}

	public AssicuratoDTO(Long id, String codiceFiscale) {
		super();
		this.id = id;
		this.codiceFiscale = codiceFiscale;
	}

	public AssicuratoDTO(Long id, String nome, String cognome, Date dataNascita, String codiceFiscale) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
	}

	public AssicuratoDTO(Long id, String nome, String cognome, Date dataNascita, String codiceFiscale,
			int numeroSinistri) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.numeroSinistri = numeroSinistri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public int getNumeroSinistri() {
		return numeroSinistri;
	}

	public void setNumeroSinistri(int numeroSinistri) {
		this.numeroSinistri = numeroSinistri;
	}

}
