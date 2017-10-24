package it.relatech.model;

import java.time.LocalDate;

public class Veicolo {

	private int id;
	private String marca;
	private String modello;
	private String targa;
	private Alimentazione alimentazione;
	private Categoria categoria;
	private Colore colore;
	private boolean disponibile;
	private LocalDate scadAssicuraz;
	private LocalDate inizioNoleggio;
	private LocalDate fineNoleggio;
	private Cliente cliente;
	private double costoNoleggio;

}
