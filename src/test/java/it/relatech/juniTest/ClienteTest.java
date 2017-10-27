package it.relatech.juniTest;

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
import it.relatech.model.Cliente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, HibernateConfiguration.class})
@WebAppConfiguration
@Transactional

public class ClienteTest {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockmvc;
	
	private ObjectMapper mapper=new ObjectMapper();
	
	@Before
	public void setUp() {
		this.mockmvc=MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void saveCliente() throws JsonProcessingException, Exception {
		Cliente client= new Cliente();
		client.setCognome("Simpson");
		client.setNome("Homer");
		
		mockmvc.perform(
				post("/cliente/add").content(mapper.writeValueAsString(client)).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
	}
	
	@Test
	public void updateCliente() throws JsonProcessingException, Exception{
		Cliente client=new Cliente();
		client.setCognome("Simpson");
		client.setCognome("Bart");
		
		mockmvc.perform(put("/cliente/update").content(mapper.writeValueAsString(client)).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

	}
	
	@Test
	public void deleteCliente() throws JsonProcessingException, Exception{
		Cliente client=new Cliente();
		client.setId(1);
		
		mockmvc.perform(delete("/cliente/delete").content(mapper.writeValueAsString(client)).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getListCLienti() throws JsonProcessingException, Exception{
		mockmvc.perform(get("/cliente/getList")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andReturn().getResponse();
	}
	
	@Test
	public void getClientById() throws JsonProcessingException,Exception{
		int id=1;
		mockmvc.perform(get("/cliente/getById"+id)).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andReturn().getResponse(); 
	}
	
}
