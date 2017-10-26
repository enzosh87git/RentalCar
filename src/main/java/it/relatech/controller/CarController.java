package it.relatech.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.relatech.model.Categoria;
import it.relatech.model.Veicolo;
import it.relatech.service.VeicoloService;

@RestController
@RequestMapping("/veicolo")
public class CarController {

	@Autowired
	private VeicoloService carserv;
	
	private final Logger logger = Logger.getLogger(CarController.class.getName());
	
	@GetMapping("/getmodel")
	public Veicolo getCarModel() { return new Veicolo(); }
	
	@PostMapping("/add")
	public ResponseEntity<Veicolo> addCar(@RequestBody Veicolo v){
		try {
			Veicolo savedCar = carserv.saveVeicolo(v);											// servizio
			logger.info("Car saved: " + savedCar);
			return new ResponseEntity<Veicolo>(savedCar, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.severe("Error: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Veicolo> update(@RequestBody Veicolo v) {
		try {
			Veicolo savedCar = carserv.updateVeicolo(v);												// servizio
			logger.info("Car Modified: " + savedCar);
			return new ResponseEntity<Veicolo>(savedCar, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe("Error: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Veicolo> delete(@RequestBody Veicolo v) {
		try {
			Veicolo delCar = carserv.deleteVeicolo(v);												// servizio
			logger.info("Car Delete: " + delCar);
			return new ResponseEntity<Veicolo>(delCar, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe("Error: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	@GetMapping("/getList")
	public ResponseEntity<List<Veicolo>> getListCars() {
		try {
			List<Veicolo> listCar = carserv.getListVeicoli();								//servizio
			return new ResponseEntity<List<Veicolo>>(listCar, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe("Error: " + e);
			return new ResponseEntity<List<Veicolo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Veicolo> getUserById(@PathVariable("id") int id) {
		try {
			Veicolo car = carserv.getVeicoloById(id);												//servizio
			logger.info("Get Car by id: " + car);
			return new ResponseEntity<Veicolo>(car, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe("Error: " + e);
			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getListByCategoria/{categoria}")
	public ResponseEntity<List<Veicolo>> getListByCategoria(@PathVariable("categoria") Categoria cat) {
		try {
			List<Veicolo> listCarCat = (List<Veicolo>) carserv.getVeicoloByCategoria(cat);												//servizio
			return new ResponseEntity<List<Veicolo>>(listCarCat, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe("Error: " + e);
			return new ResponseEntity<List<Veicolo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@GetMapping("/getListDisp")
//	public ResponseEntity<List<Veicolo>> getListCarsAvail() {
//		try {
//			List<Veicolo> listCarAvail = carserv										//servizio
//			return new ResponseEntity<List<Veicolo>>(listCarAvail, HttpStatus.OK);
//		} catch (Exception e) {
//			logger.severe("Error: " + e);
//			return new ResponseEntity<List<Veicolo>>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@PutMapping("/noleggia")
//	public ResponseEntity<Veicolo> noleggia(@RequestBody Veicolo v) {
//		try {
//			Veicolo rentCar = carserv.												// servizio
//			logger.info("Car Modified: " + rentCar);
//			return new ResponseEntity<Veicolo>(rentCar, HttpStatus.OK);
//		} catch (Exception e) {
//			logger.severe("Error: " + e);
//			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	
//	@PutMapping("/restituisci")
//	public ResponseEntity<Veicolo> restituisci(@RequestBody Veicolo v) {
//		try {
//			Veicolo relCar = carserv.												// servizio
//			logger.info("Car Modified: " + relCar);
//			return new ResponseEntity<Veicolo>(relCar, HttpStatus.OK);
//		} catch (Exception e) {
//			logger.severe("Error: " + e);
//			return new ResponseEntity<Veicolo>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	
	
	
}
