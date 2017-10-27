package it.relatech.juniTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.relatech.config.AppConfig;
import it.relatech.config.HibernateConfiguration;
import it.relatech.model.Alimentazione;
import it.relatech.model.Categoria;
import it.relatech.model.Cliente;
import it.relatech.model.Colore;
import it.relatech.model.Noleggio;
import it.relatech.model.Veicolo;
import it.relatech.service.ClienteService;
import it.relatech.service.VeicoloService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, HibernateConfiguration.class })
@WebAppConfiguration
@Transactional
public class NoleggioTest {
	
	@Autowired
	public ClienteService cs;
	@Autowired
	public VeicoloService vs;
	
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
     
	@Test
	public void saveNoleggio () throws JsonProcessingException, Exception {
		
		Noleggio noleggio = new Noleggio();
		Cliente cliente = cs.getClienteById(1);
		Veicolo veicolo = vs.getVeicoloById(1);

		noleggio.setInizioNoleggio(LocalDate.of(2017, Month.OCTOBER, 28));
		noleggio.setFineNoleggio(LocalDate.of(2017, Month.OCTOBER, 29));
		noleggio.setCostoNoleggio(30);
		noleggio.setCliente(cliente);
		noleggio.setVeicolo(veicolo);
		
		mockMvc.perform(
				post("/noleggio/add").content(mapper.writeValueAsString(noleggio)).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isCreated());;
	}
	
	@Test
	public void deleteNoleggio () throws JsonProcessingException, Exception {
		
		Noleggio noleggio = new Noleggio();
		
		noleggio.setId(6);
		
		mockMvc.perform(
				delete("/noleggio/delete").content(mapper.writeValueAsString(noleggio)).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getListNoleggi() throws JsonProcessingException, Exception {
		mockMvc.perform(get("/noleggio/getList")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
	}
	
}
