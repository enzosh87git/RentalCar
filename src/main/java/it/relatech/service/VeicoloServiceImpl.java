package it.relatech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.relatech.dao.VeicoloDao;
import it.relatech.model.Categoria;
import it.relatech.model.Veicolo;

@Service
public class VeicoloServiceImpl implements VeicoloService {

	@Autowired
	private VeicoloDao veicoloDao;

	public Veicolo saveVeicolo(Veicolo veicolo) {
		return veicoloDao.saveVeicolo(veicolo);
	}

	public Veicolo updateVeicolo(Veicolo veicolo) {
		return veicoloDao.updateVeicolo(veicolo);
	}

	public Veicolo deleteVeicolo(Veicolo veicolo) {
		return veicoloDao.deleteVeicolo(veicolo);
	}

	public List<Veicolo> getListVeicoli() {
		return veicoloDao.getListVeicoli();
	}

	public Veicolo getVeicoloById(int id) {
		return veicoloDao.getVeicoloById(id);
	}

	public Veicolo getVeicoloByCategoria(Categoria categoria) {
		return veicoloDao.getVeicoloByCategoria(categoria);
	}

}
