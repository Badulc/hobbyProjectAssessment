package com.qa.hobbySnkrproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hobbySnkrproject.domain.SneakerDom;

@Repository
public interface SnkrRepo extends JpaRepository<SneakerDom, Integer>{
	
	//spring should auto generate all of basic CRUD functionality
	
	List<SneakerDom> findByNameIgnoreCase(String name);
	List<SneakerDom> findBySerialNo(Integer serialNo);
	List<SneakerDom> findBySize(Integer size);
	List<SneakerDom> findByCondit(Integer condit);
	List<SneakerDom> findByColour1IgnoreCase(String colour1);
	List<SneakerDom> findByColour2IgnoreCase(String colour2);
	List<SneakerDom> findByMaterialIgnoreCase(String material);
	

}
