package it.relatech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import it.relatech.model.Categoria;
import it.relatech.model.Veicolo;

public class VeicoloDaoImpl extends AbstractDao implements VeicoloDao {

	public Veicolo saveVeicolo(Veicolo veicolo) { return saveVeicolo(veicolo); }

	public Veicolo updateVeicolo(Veicolo veicolo) { update(veicolo);	return veicolo; }

	public Veicolo deleteVeicolo(Veicolo veicolo) { delete(veicolo); 	return veicolo; }

	public List<Veicolo> getListVeicoli() { return getSession().createCriteria(Veicolo.class).list(); }

	public Veicolo getVeicoloById(int id) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("id", id));
		return (Veicolo) criteria.uniqueResult();
	}

	public Veicolo getVeicoloByCategoria(Categoria categoria) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
	      criteria.add(Restrictions.eq("Categoria", categoria));
			return (Veicolo) criteria.uniqueResult();
	}

	public List<Veicolo> getListDisp() { return getSession().createCriteria(Veicolo.class).list(); }

	public Veicolo noleggiaVeicolo(Veicolo veicolo) {
		return veicolo;
	}

	public Veicolo restituisciVeicolo(Veicolo veicolo) {
		return veicolo;
	}
	
}
