package com.qa.hobbySnkrproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class SneakerDom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment id
	// attributes of sneaker data
	public Integer id;

	@Column(nullable = false)
	public String name;

	@Column(nullable = false)
	public Integer serialNo;

	@Column(nullable = false)
	public Integer size;

	@Column(nullable = false)
	public Integer condit;

	@Column(nullable = false)
	public String colour1;

	@Column(nullable = false)
	public String colour2;

	@Column(nullable = false)
	public String material;

	public SneakerDom(Integer id, String name, Integer serialNo, Integer size, Integer condition, String colour1,
			String colour2, String material) {
		super();
		this.id = id;
		this.name = name;
		this.serialNo = serialNo;
		this.size = size;
		this.condit = condition;
		this.colour1 = colour1;
		this.colour2 = colour2;
		this.material = material;
	}

	public SneakerDom() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getserialNo() {
		return serialNo;
	}

	public void setserialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getCondit() {
		return condit;
	}

	public void setCondit(Integer condit) {
		this.condit = condit;
	}

	public String getColour1() {
		return colour1;
	}

	public void setColour1(String colour1) {
		this.colour1 = colour1;
	}

	public String getColour2() {
		return colour2;
	}

	public void setColour2(String colour2) {
		this.colour2 = colour2;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "SneakerDom [id=" + id + ", name=" + name + ", serialNo=" + serialNo + ", size=" + size + ", condit="
				+ condit + ", colour1=" + colour1 + ", colour2=" + colour2 + ", material=" + material + "]";
	}

}

