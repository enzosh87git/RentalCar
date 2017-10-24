package it.relatech.service;

import java.util.List;

import it.relatech.model.Noleggio;

public interface NoleggioService {

  List<Noleggio> getListDisp();
	
	Noleggio saveNoleggio(Noleggio noleggio);
	
	Noleggio deleteNoleggio(Noleggio noleggio);
	
}
