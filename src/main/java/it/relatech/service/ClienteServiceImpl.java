package it.relatech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.relatech.dao.ClienteDao;
import it.relatech.model.Cliente;

public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDao clienteDao;

	public Cliente saveCliente(Cliente cliente) { return clienteDao.saveCliente(cliente); }

	public Cliente updateCliente(Cliente cliente) { return clienteDao.updateCliente(cliente); }

	public Cliente deleteCliente(Cliente cliente) { return clienteDao.deleteCliente(cliente); }

	public List<Cliente> getListCLienti() { return clienteDao.getListCLienti(); }
}
