package com.qa.hobbySnkrproject.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hobbySnkrproject.domain.SneakerDom;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:sneaker-schema.sql", "classpath:sneaker-data.sql"}, executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
public class SneakerDomControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void TestCreate() throws Exception {
		SneakerDom testSneaker = new SneakerDom(null, "nike1", 1, 1, 1, "blue", "blue", "leather");
		
		String testSneakerDomAsJSON = this.mapper.writeValueAsString(testSneaker);
		RequestBuilder req = post("/createSnkr").contentType(MediaType.APPLICATION_JSON).content(testSneakerDomAsJSON);
		
		SneakerDom testCreatedSneaker = new SneakerDom(3, "nike1", 1, 1, 1, "blue", "blue", "leather");
		String testCreatedSneakerAsJSON = this.mapper.writeValueAsString(testCreatedSneaker);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedSneakerAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void getAllTest() throws Exception {
		RequestBuilder req = get("/getAllSnkr");
		
		List<SneakerDom> testSneaks = List.of(new SneakerDom(1, "nike1", 1, 1, 1, "blue", "blue", "leather"), new SneakerDom(2,"nike2", 2, 2, 2, "black", "black", "suede"));
		String json = this.mapper.writeValueAsString(testSneaks);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
		
		
	}
	
	
	

}
