package it.relatech.dao;

import java.util.List;

import it.relatech.model.Cliente;

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
	
}
