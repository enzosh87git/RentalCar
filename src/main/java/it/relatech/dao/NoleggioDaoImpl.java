package it.relatech.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.relatech.model.Noleggio;

@Repository
@Transactional
public class NoleggioDaoImpl extends AbstractDao implements NoleggioDao {

	@Override
	public List<Noleggio> getListDisp() {
		return getSession().createCriteria(Noleggio.class).list();
	}

	@Override
	public Noleggio saveNoleggio(Noleggio noleggio) {
		persist(noleggio);
		return noleggio;
	}

	@Override
	public Noleggio deleteNoleggio(Noleggio noleggio) {
		delete(noleggio);
		return noleggio;
	}

	}

