package it.relatech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Veicolo {

	@Id
	@GeneratedValue
	private int id;
	
	private String marca;
	
	private String modello;
	
	private String targa;
	
	@Enumerated(EnumType.STRING)
	private Alimentazione alimentazione;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@Enumerated(EnumType.STRING)
	private Colore colore;
	
	@OneToMany(mappedBy="veicolo", fetch = FetchType.EAGER)
	private List<Noleggio> listNoleggi;

	public Veicolo() { listNoleggi = new ArrayList<>(); }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Alimentazione getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(Alimentazione alimentazione) {
		this.alimentazione = alimentazione;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}

	public List<Noleggio> getListNoleggi() {
		return listNoleggi;
	}

	public void setListNoleggi(List<Noleggio> listNoleggi) {
		this.listNoleggi = listNoleggi;
	}

	@Override
	public String toString() {
		return "Veicolo [id=" + id + ", marca=" + marca + ", modello=" + modello + ", targa=" + targa
				+ ", alimentazione=" + alimentazione + ", categoria=" + categoria + ", colore=" + colore
				+ ", listNoleggi=" + listNoleggi + "]";
	}
	
	
	
//	private boolean disponibile;
//	private LocalDate scadAssicuraz;
//	private LocalDate inizioNoleggio;
//	private LocalDate fineNoleggio;
//	private Cliente cliente;
//	private double costoNoleggio;

}
