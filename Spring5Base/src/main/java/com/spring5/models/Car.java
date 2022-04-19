package com.spring5.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Car {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="model")
	private String model;
	
	@Column(name="annee")
	private String annee;

	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(Long id, String model, String annee) {
		super();
		this.id = id;
		this.model = model;
		this.annee = annee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	

}
