package com.qa.hobbySnkrproject.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hobbySnkrproject.domain.SneakerDom;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:sneaker-schema.sql",
		"classpath:sneaker-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
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

		List<SneakerDom> testSneaks = List.of(new SneakerDom(1, "nike1", 1, 1, 1, "blue", "blue", "leather"),
				new SneakerDom(2, "nike2", 2, 2, 2, "black", "black", "suede"));
		String json = this.mapper.writeValueAsString(testSneaks);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}
	
	@Test
	void getByIdTest() throws Exception {
		RequestBuilder req = get("/getSnkr/1");
		String json = this.mapper.writeValueAsString(new SneakerDom(1, "nike1", 1, 1, 1, "blue", "blue", "leather"));
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test 
	void getByNameTest() throws Exception {
		RequestBuilder req = get("/getSnkrByName/nike1");
		
		List<SneakerDom> testSneaks = List.of(new SneakerDom(1, "nike1", 1, 1, 1, "blue", "blue", "leather"));
		String json = this.mapper.writeValueAsString(testSneaks);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
		
		@Test
		void getBySizeTest() throws Exception {
			RequestBuilder req = get("/getSnkrBySize/1");
			
			List<SneakerDom> testSneaks = List.of(new SneakerDom(1, "nike1", 1, 1, 1, "blue", "blue", "leather"));
			String json = this.mapper.writeValueAsString(testSneaks);
			
			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().json(json);
			
			this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
		
		@Test
		void getBySerialNoTest() throws Exception {
			RequestBuilder req = get("/getSnkrBySerialNo/1");
			
			List<SneakerDom> testSneaks = List.of(new SneakerDom(1, "nike1", 1, 1, 1, "blue", "blue", "leather"));
			String json = this.mapper.writeValueAsString(testSneaks);
			
			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().json(json);
			
			this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
		
		@Test
		void getByConditTest() throws Exception {
			RequestBuilder req = get("/getSnkrByCondit/1");
			
			List<SneakerDom> testSneaks = List.of(new SneakerDom(1, "nike1", 1, 1, 1, "blue", "blue", "leather"));
			String json = this.mapper.writeValueAsString(testSneaks);
			
			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().json(json);
			
			this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
		
		@Test
		void getByColour1Test() throws Exception {
			RequestBuilder req = get("/getSnkrByColour1/blue");
			
			List<SneakerDom> testSneaks = List.of(new SneakerDom(1, "nike1", 1, 1, 1, "blue", "blue", "leather"));
			String json = this.mapper.writeValueAsString(testSneaks);
			
			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().json(json);
			
			this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
		
		@Test
		void getByColour2Test() throws Exception {
			RequestBuilder req = get("/getSnkrByColour2/blue");
			
			List<SneakerDom> testSneaks = List.of(new SneakerDom(1, "nike1", 1, 1, 1, "blue", "blue", "leather"));
			String json = this.mapper.writeValueAsString(testSneaks);
			
			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().json(json);
			
			this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
		
		@Test
		void getByMaterialTest() throws Exception {
			RequestBuilder req = get("/getSnkrByMaterial/leather");
			
			List<SneakerDom> testSneaks = List.of(new SneakerDom(1, "nike1", 1, 1, 1, "blue", "blue", "leather"));
			String json = this.mapper.writeValueAsString(testSneaks);
			
			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().json(json);
			
			this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
		
		@Test
		void replaceSnkrTest() throws Exception {
			SneakerDom testSneaker = new SneakerDom(null, "replacetest", 1, 1, 1, "blue", "blue", "leather");
			String testSneakerDomAsJSON = this.mapper.writeValueAsString(testSneaker);
			
			RequestBuilder req = put("/replaceSnkr/1").contentType(MediaType.APPLICATION_JSON).content(testSneakerDomAsJSON);
			SneakerDom testUpdatedSneaker = new SneakerDom(1, "replacetest", 1, 1, 1, "blue", "blue", "leather");
			String testUpdatedSneakerAsJSON = this.mapper.writeValueAsString(testUpdatedSneaker);
			
			ResultMatcher checkStatus = status().isAccepted();
			ResultMatcher checkBody = content().json(testUpdatedSneakerAsJSON);
			
			this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
		
		@Test
		void deleteTest() throws Exception {
			this.mvc.perform(delete("/removeSnkr/1")).andExpect(status().isNoContent());
		}
}
