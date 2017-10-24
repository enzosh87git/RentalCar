package it.relatech.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@OneToMany(mappedBy="veicolo")
	private List<Noleggio> listNoleggi;
	
//	private boolean disponibile;
//	private LocalDate scadAssicuraz;
//	private LocalDate inizioNoleggio;
//	private LocalDate fineNoleggio;
//	private Cliente cliente;
//	private double costoNoleggio;

}
