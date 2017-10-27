package it.relatech.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.relatech.model.Cliente;
import it.relatech.model.Noleggio;
import it.relatech.service.NoleggioService;

@RestController
@RequestMapping("/noleggio")
public class NoleggioController {
	
	@Autowired
	private NoleggioService noleggioservice;

	private final Logger logger = Logger.getLogger(NoleggioController.class.getName());
	
	@GetMapping("/getmodel")
	public Noleggio getModel() {
		return new Noleggio();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Noleggio> addNoleggio(@RequestBody Noleggio noleggio) {
		try {
			Noleggio noleggiosalvato = noleggioservice.saveNoleggio(noleggio);
			logger.info("Noleggio salvato: " + noleggiosalvato);
			return new ResponseEntity<Noleggio>(noleggiosalvato, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Noleggio>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<Noleggio> deleteNoleggio(@RequestBody Noleggio noleggio) {
		try {
			Noleggio deletenoleggio = noleggioservice.deleteNoleggio(noleggio);
			logger.info("Noleggio eliminato: " + deletenoleggio);
			return new ResponseEntity<Noleggio>(deletenoleggio, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<Noleggio>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getList")
	public ResponseEntity<List<Noleggio>> getListNoleggi() {
		try {
			List<Noleggio> listanoleggi = noleggioservice.getListDisp();
			logger.info("get noleggi: " + noleggioservice);
			return new ResponseEntity<List<Noleggio>>(listanoleggi, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe("Errore: " + e);
			return new ResponseEntity<List<Noleggio>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}
