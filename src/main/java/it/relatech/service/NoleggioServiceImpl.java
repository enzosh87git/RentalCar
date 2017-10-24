//package it.relatech.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import it.relatech.dao.NoleggioDao;
//
//public class NoleggioServiceImpl implements NoleggioService {
//	
//	@Autowired
//	private NoleggioDao noleggioDao;
//	
//	public List<Veicolo> getListDisp() {
//		return noleggioDao.getListDisp();
//	}
//
//	public Noleggio noleggiaVeicolo(Noleggio noleggio) {
//		return noleggioDao.noleggiaVeicolo(noleggio);
//	}
//
//	public Noleggio restituisciVeicolo(Noleggio noleggio) {
//		return noleggioDao.restituisciVeicolo(noleggio);
//	}
//
//}
