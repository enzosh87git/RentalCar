package it.relatech.service;

import java.util.List;

import it.relatech.model.Categoria;
import it.relatech.model.Veicolo;

public interface VeicoloService {
	
	Veicolo saveVeicolo(Veicolo veicolo);
	
	Veicolo updateVeicolo (Veicolo veicolo);
	
	Veicolo deleteVeicolo(Veicolo veicolo);
	
	List<Veicolo> getListVeicoli();
	
	Veicolo getVeicoloById (int id);
	
	Veicolo getVeicoloByCategoria (Categoria categoria);
	
	List<Veicolo> getListDisp();
	
	Veicolo noleggiaVeicolo(Veicolo veicolo);
	
	Veicolo restituisciVeicolo(Veicolo veicolo);

}
