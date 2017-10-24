package it.relatech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.relatech.dao.NoleggioDao;
import it.relatech.model.Noleggio;
import it.relatech.model.Veicolo;	

@Service
public class NoleggioServiceImpl implements NoleggioService {
	
	@Autowired
	private NoleggioDao noleggioDao;
	
	public List<Noleggio> getListDisp() {
		return noleggioDao.getListDisp();
	}

	public Noleggio saveNoleggio(Noleggio noleggio) {
		return noleggioDao.saveNoleggio(noleggio);
	}

	@Override
	public Noleggio deleteNoleggio(Noleggio noleggio) {
		return noleggioDao.deleteNoleggio(noleggio);	}

}
