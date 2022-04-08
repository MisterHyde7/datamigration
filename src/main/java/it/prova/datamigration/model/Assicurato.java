package it.prova.datamigration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "datamigration_new")
public class Assicurato {

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "dataNascita")
	private Date dataNascita;
	@Column(name = "codiceFiscale")
	private String codiceFiscale;
	@Column(name = "numeroSinistri")
	private int numeroSinistri;

	public Assicurato() {
		super();
	}

	public Assicurato(Long id, String nome, String cognome, Date dataNascita, String codiceFiscale,
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
