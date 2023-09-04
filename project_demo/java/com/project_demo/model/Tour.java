package com.project_demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tour")
public class Tour {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int noOfPersons;
	private int tourMonth;
	//@Column(name="email")
	private String email;
	private String password;
	
	@OneToOne(mappedBy="tour",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Enquiry enquiry;

	
	public Tour() {
		super();
	}

	public Tour(int id, String name, int noOfPersons, int tourMonth, String email, String password, Enquiry enquiry) {
		super();
		this.id = id;
		this.name = name;
		this.noOfPersons = noOfPersons;
		this.tourMonth = tourMonth;
		this.email = email;
		this.password = password;
		this.enquiry = enquiry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}

	public int getTourMonth() {
		return tourMonth;
	}

	public void setTourMonth(int tourMonth) {
		this.tourMonth = tourMonth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Enquiry getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(Enquiry enquiry) {
		this.enquiry = enquiry;
	}
	
	
}