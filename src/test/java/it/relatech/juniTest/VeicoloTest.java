package it.relatech.juniTest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import it.relatech.model.Colore;
import it.relatech.model.Veicolo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, HibernateConfiguration.class })
@WebAppConfiguration
@Transactional
public class VeicoloTest {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	// TEST URL /veicolo/add
	@Test
	public void saveCar() throws JsonProcessingException, Exception {
		Veicolo car = new Veicolo();
		car.setMarca("Nissan");
		car.setModello("Quasqai");
		car.setTarga("RO387CE");
		car.setAlimentazione(Alimentazione.DIESEL);
		car.setCategoria(Categoria.SUV);
		car.setColore(Colore.BIANCO);
		
		mockMvc.perform(
				post("/veicolo/add").content(mapper.writeValueAsString(car)).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isCreated());
	}
	
	// TEST URL /veicolo/update
	@Test
	public void updateCar() throws JsonProcessingException, Exception {
		Veicolo car = new Veicolo();
		car.setId(4);
		car.setMarca("Nissan");
		car.setModello("Micra");
		car.setTarga("RO387CE");
		car.setAlimentazione(Alimentazione.BENZINA);
		car.setCategoria(Categoria.UTILITARIA);
		car.setColore(Colore.LILLA);
		
		mockMvc.perform(
				put("/veicolo/update").content(mapper.writeValueAsString(car)).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}
	
	// TEST URL /veicolo/delete
		@Test
		public void deleteCar() throws JsonProcessingException, Exception {
			Veicolo car = new Veicolo();
			car.setId(3);
			
			mockMvc.perform(
					delete("/veicolo/delete").content(mapper.writeValueAsString(car)).contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isOk());
		}

	// TEST URL /veicolo/getList
		@Test
		public void getListCars() throws JsonProcessingException, Exception {
			mockMvc.perform(get("/veicolo/getList")).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
		}
		
	// TEST URL /veicolo/getById
		@Test
		public void getCarById() throws JsonProcessingException, Exception {
			int id = 1;
			mockMvc.perform(get("/veicolo/getById/" + id)).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andReturn()
			.getResponse();
		}

		// TEST URL /veicolo/getByCategoria
				@Test
				public void getCarByCategoria() throws JsonProcessingException, Exception {
					Categoria cat = Categoria.SUV;
					mockMvc.perform(get("/veicolo/getListByCategoria/"+cat)).andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andReturn()
					.getResponse();
				}
}
