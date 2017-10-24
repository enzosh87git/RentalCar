package it.relatech.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.relatech.model.Cliente;
import it.relatech.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClientController {

	@Autowired
	private ClienteService clienteservice;

	private final Logger logger = Logger.getLogger(ClientController.class.getName());

	@GetMapping("/getmodel")
	public Cliente getModel() {
		return new Cliente();
	}

	@PostMapping("/add")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
		try {
			Cliente savecliente = clienteservice.saveCliente(cliente);
			logger.info("Cliente salvato: " + savecliente);
			return new ResponseEntity<Cliente>(savecliente, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
		try {
			Cliente updatecliente = clienteservice.updateCliente(cliente);
			logger.info("Cliente aggiornato: " + updatecliente);
			return new ResponseEntity<Cliente>(updatecliente, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Cliente> deleteCliente(@RequestBody Cliente cliente) {
		try {
			Cliente deletecliente = clienteservice.deleteCliente(cliente);
			logger.info("Cliente eliminato: " + deletecliente);
			return new ResponseEntity<Cliente>(deletecliente, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getList")
	public ResponseEntity<List<Cliente>> getListClienti() {
		try {
			List<Cliente> listaclienti = clienteservice.getListCLienti();
			logger.info("get client by id: " + listaclienti);
			return new ResponseEntity<List<Cliente>>(HttpStatus.OK);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getById")
	public ResponseEntity<List<Cliente>> getById(@RequestBody int id){
		try {
			List<Cliente> idutente = (List<Cliente>) clienteservice.getClienteById(id);
			logger.info("get client by id: " + idutente);
			return new ResponseEntity<List<Cliente>>(HttpStatus.OK);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
