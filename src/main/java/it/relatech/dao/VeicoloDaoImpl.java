package it.relatech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.relatech.model.Categoria;
import it.relatech.model.Veicolo;

@Repository
@Transactional
public class VeicoloDaoImpl extends AbstractDao implements VeicoloDao {

	public Veicolo saveVeicolo(Veicolo veicolo) { 
		persist(veicolo); 
		return veicolo; }

	public Veicolo updateVeicolo(Veicolo veicolo) { 
		update(veicolo);	
	   return veicolo; }

	public Veicolo deleteVeicolo(Veicolo veicolo) { 
		delete(veicolo); 
	   return veicolo; }

	@SuppressWarnings("unchecked")
	public List<Veicolo> getListVeicoli() { 
		return getSession().createCriteria(Veicolo.class).list(); }

	public Veicolo getVeicoloById(int id) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
		criteria.add(Restrictions.eq("id", id));
		return (Veicolo) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Veicolo> getVeicoloByCategoria(Categoria categoria) {
		Criteria criteria = getSession().createCriteria(Veicolo.class);
	      criteria.add(Restrictions.eq("categoria", categoria));
			return criteria.list();
	}
	
}
