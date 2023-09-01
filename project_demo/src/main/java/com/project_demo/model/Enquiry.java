package com.project_demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="enquiry")
public class Enquiry {
	@Id
	@GeneratedValue
	private int id;
	private int enquiryNum;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="tour_id")
	private Tour tour;
	
	@OneToMany(mappedBy="enquiry",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Destinations> destination;
	
	public Enquiry() {
		super();
	}
	public Enquiry(int id, int enquiryNum) {
		super();
		this.id = id;
		this.enquiryNum = enquiryNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnquiryNum() {
		return enquiryNum;
	}
	public void setEnquiryNum(int enquiryNum) {
		this.enquiryNum = enquiryNum;
	}
	public List<Destinations> getDestination() {
		return destination;
	}
	public void setDestination(List<Destinations> destination) {
		this.destination = destination;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	
	

}
