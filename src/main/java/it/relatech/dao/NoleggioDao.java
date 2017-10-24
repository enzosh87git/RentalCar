package it.relatech.dao;

import java.util.List;

import it.relatech.model.Noleggio;

public interface NoleggioDao {
	
    List<Noleggio> getListDisp();
	
	Noleggio saveNoleggio(Noleggio noleggio);
	
	Noleggio deleteNoleggio(Noleggio noleggio);
}
