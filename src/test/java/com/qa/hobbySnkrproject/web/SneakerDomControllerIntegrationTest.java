package com.qa.hobbySnkrproject.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hobbySnkrproject.domain.SneakerDom;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SneakerDomControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void TestCreate() throws Exception {
		SneakerDom testSneaker = new SneakerDom(null, "nike", 1, 1, 1, "blue", "blue", "leather");
		
		String testSneakerDomAsJSON = this.mapper.writeValueAsString(testSneaker);
		RequestBuilder req = post("/createSnkr").contentType(MediaType.APPLICATION_JSON).content(testSneakerDomAsJSON);
		
		SneakerDom testCreatedSneaker = new SneakerDom(1, "nike", 1, 1, 1, "blue", "blue", "leather");
		String testCreatedSneakerAsJSON = this.mapper.writeValueAsString(testCreatedSneaker);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedSneakerAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	

}
