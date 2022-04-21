package com.qa.hobbySnkrproject.web;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hobbySnkrproject.domain.SneakerDom;

import com.qa.hobbySnkrproject.service.SnkrService;

@RestController // annotation to tell spring this is a controller
//Rest Compliant or REST API

public class SneakerDomController {

	private SnkrService service;

	@Autowired // tell spring to fetch SnkrService from the context
	// dependency injection
	public SneakerDomController(SnkrService service) {
		super();
		this.service = service;
	}

	// endpoints
	// creating https response codes
	// @GetMapping()

	// CRUD functionality
	// repsonse entity is an extension of HttpEntity
	// that represents http reponses including status code,headers and body

	@PostMapping("/createSnkr") // 201 - created
	// create sneaker list
	public ResponseEntity<SneakerDom> createSneaker(@RequestBody SneakerDom s) {
		SneakerDom created = this.service.createSneaker(s);
		// create a response
		ResponseEntity<SneakerDom> response = new ResponseEntity<SneakerDom>(created, HttpStatus.CREATED);
		// returning response code
		return response;
	}

	// read all from list method
	@GetMapping("/getAllSnkr") // 200 - ok
	public ResponseEntity<List<SneakerDom>> getAllSneakers() {
		return ResponseEntity.ok(this.service.getAllSnkrs());
	}

	// read one from list
	@GetMapping("/getSnkr/{id}") // 200 - ok
	public SneakerDom getSneaker(@PathVariable Integer id) {
		return this.service.getSnkr(id);
	}

	// update method
	@PutMapping("/replaceSnkr/{id}") // 202 - accepted
	public ResponseEntity<SneakerDom> replaceSneaker(@PathVariable Integer id, @RequestBody SneakerDom repSnkr) {
		SneakerDom body = this.service.replaceSnkr(id, repSnkr);
		ResponseEntity<SneakerDom> response = new ResponseEntity<SneakerDom>(body, HttpStatus.ACCEPTED);
		return response;
	}

	// delete from list
	@DeleteMapping("/removeSnkr/{id}") // 204 - no content
	public ResponseEntity<?> removeSneaker(@PathVariable Integer id) {
		this.service.removeSnkr(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//read by name
	@GetMapping("/getSnkrByName/{name}")
	public ResponseEntity<List<SneakerDom>> getSneakerByName(@PathVariable String name) {
		List<SneakerDom> found = this.service.getSnkrByName(name);
		return ResponseEntity.ok(found);
	}
	
	//read by size
	@GetMapping("/getSnkrBySize/{size}")
	public ResponseEntity<List<SneakerDom>> getSneakerBySize(@PathVariable Integer size) {
		List<SneakerDom> found = this.service.getSnkrBySize(size);
		return ResponseEntity.ok(found);
	}
	
	//read by serialNo
	@GetMapping("/getSnkrBySerialNo/{serialNo}")
	public ResponseEntity<List<SneakerDom>> getSneakerBySerialNo(@PathVariable Integer serialNo) {
		List<SneakerDom> found = this.service.getSnkrBySerialNo(serialNo);
		return ResponseEntity.ok(found);
	}
	
	//read by condition - tested on postman
	@GetMapping("/getSnkrByCondition/{condition}")
	public ResponseEntity<List<SneakerDom>> getSneakerByCondition(@PathVariable Integer condition) {
		List<SneakerDom> found = this.service.getSnkrByCondition(condition);
		return ResponseEntity.ok(found);
	}
	
	@GetMapping("/getSnkrByColour1/{colour1}")
	public ResponseEntity<List<SneakerDom>> getSneakerByColour1(@PathVariable String colour1) {
		List<SneakerDom> found = this.service.getSnkrByColour1(colour1);
		return ResponseEntity.ok(found);
		
	}
	
	@GetMapping("/getSnkrByColour2/{colour2}")
	public ResponseEntity<List<SneakerDom>> getSneakerByColour2(@PathVariable String colour2) {
		List<SneakerDom> found = this.service.getSnkrByColour2(colour2);
		return ResponseEntity.ok(found);
		
	}
	
	@GetMapping("/getSnkrByMaterial/{material}")
	public ResponseEntity<List<SneakerDom>> getSneakerByMaterial(@PathVariable String material) {
		List<SneakerDom> found = this.service.getSnkrByMaterial(material);
		return ResponseEntity.ok(found);
		
	}
	


}

