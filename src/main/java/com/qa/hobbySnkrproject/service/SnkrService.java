package com.qa.hobbySnkrproject.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.hobbySnkrproject.domain.SneakerDom;
import com.qa.hobbySnkrproject.repo.SnkrRepo;

@Service

public class SnkrService implements ServiceIF<SneakerDom> {
	
	// list for storing data without db
	//repo here
	private SnkrRepo repo;
	
	@Autowired
	public SnkrService(SnkrRepo repo) {
		super();
		this.repo=repo;
	}
		
		
		//create
		public SneakerDom createSneaker(SneakerDom s) {
			SneakerDom created = this.repo.save(s);
			return created;
		}
		
		
		//get all
		public List<SneakerDom> getAllSnkrs() {
			return this.repo.findAll();
		}
		
		//get one
		public SneakerDom getSnkr(Integer id) {
			Optional<SneakerDom> found = this.repo.findById(id);
			return found.get();
			
		}
		
		//update
		public SneakerDom replaceSnkr(Integer id, SneakerDom repSnkr) {
			SneakerDom existing = this.repo.findById(id).get();
			existing.setName(repSnkr.getName());
			existing.setserialNo(repSnkr.getserialNo());
			existing.setSize(repSnkr.getSize());
			existing.setCondition(repSnkr.getCondition());
			existing.setColour1(repSnkr.getColour1());
			existing.setColour2(repSnkr.getColour2());
			existing.setMaterial(repSnkr.getMaterial());
			SneakerDom updated = this.repo.save(existing);
			return updated;
			
			
		}
		
		//delete
		public void removeSnkr(@PathVariable Integer id) {
			this.repo.deleteById(id);
			
		}
		
		//SELECT FROM snkrDom WHERE NAME =
		public List<SneakerDom> getSnkrByName(String name) {
			List<SneakerDom> found = this.repo.findByNameIgnoreCase(name);
			return found;
		}
		
		//select all from snkrDom where size =
		public List<SneakerDom> getSnkrBySize(Integer size) {
			List<SneakerDom> found = this.repo.findBySize(size);
			return found;
		}
		
		public List<SneakerDom> getSnkrBySerialNo(Integer size) {
			List<SneakerDom> found = this.repo.findBySerialNo(size);
			return found;
		}
		
		public List<SneakerDom> getSnkrByCondition(Integer condition) {
			List<SneakerDom> found = this.repo.findByCondition(condition);
			return found;
		}
		
		public List<SneakerDom> getSnkrByColour1(String colour1) {
			List<SneakerDom> found = this.repo.findByColour1IgnoreCase(colour1);
			return found;
		}
		
		public List<SneakerDom> getSnkrByColour2(String colour2) {
			List<SneakerDom> found = this.repo.findByColour2IgnoreCase(colour2);
			return found;
		}
		
		public List<SneakerDom> getSnkrByMaterial(String material) {
			List<SneakerDom> found = this.repo.findByMaterialIgnoreCase(material);
			return found;
		}
		
		
}
