package it.relatech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.relatech.model.Cliente;

@Repository
@Transactional
public class ClienteDaoImpl extends AbstractDao implements ClienteDao {

	public Cliente saveCliente(Cliente cliente) {
		return saveCliente(cliente);
	}

	public Cliente updateCliente(Cliente cliente) {
		update(cliente);
		return cliente;
	}

	public Cliente deleteCliente(Cliente cliente) {
		delete(cliente);
		return cliente;
	}

	public List<Cliente> getListCLienti() {
		return getSession().createCriteria(Cliente.class).list();
	}	
	
	@Override
	public Cliente getClienteById(int id) {
		Criteria criteria = getSession().createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("id", id));
		return (Cliente) criteria.uniqueResult();
	}
}
