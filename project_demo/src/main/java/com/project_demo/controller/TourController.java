package com.project_demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project_demo.model.Tour;
import com.project_demo.service.TourService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/v1/tour")
@Tag(name="tour")
public class TourController {
	
	//import Logger from org.slf4j
	private final static Logger logger = LoggerFactory.getLogger(TourController.class);
	
	@Autowired
	private TourService tourService;
	
	@GetMapping("/getUser")
	public ResponseEntity<List<Tour>>getUser(){
		System.out.println("hello");
		logger.info("world");
		logger.debug("Debug");
		logger.warn("Warn");
		logger.error("Error");
		return ResponseEntity.status(200).body(tourService.getUser());
	}
	
	@GetMapping("/sortAllUser")
	public Page<Tour> getAllUser(
				@RequestParam(defaultValue = "0") int page, 
				@RequestParam(defaultValue = "10") int size,
				@RequestParam(defaultValue = "tourMonth") String sortField,
				@RequestParam(defaultValue = "asc") String sortOrder
			){
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
		return tourService.getAllUser(pageRequest);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<String>addUser(@RequestBody Tour tour){
		boolean dataSaved= tourService.adduser(tour);
		if(dataSaved) {
			return ResponseEntity.status(200).body("Enquiry submitted successfully");
		}
		else {
			return ResponseEntity.status(404).body("Something went wrong");
		}
		
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String>updateuser(@PathVariable Long id,@RequestBody Tour tour){
	boolean userData=tourService.updateuser(id,tour);
	if(userData) {
		return ResponseEntity.status(200).body("Enquiry updated successfully");
		
	}
	else {
		return ResponseEntity.status(404).body("no record");
	}
	}
	@PutMapping("/updateByQuery/{noOfPersons}/{id}")
	public ResponseEntity<Integer> updateUserQuery(@PathVariable int noOfPersons,@PathVariable int id){
		return ResponseEntity.status(200).body(tourService.updateUserQuery(noOfPersons,id));
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Long id){
		boolean userDeleted=tourService.deleteUser(id);
		if(userDeleted) {
			return ResponseEntity.status(200).body("user deleted successfully");
		}
		else {
			return ResponseEntity.status(404).body("No records");
		}
	}
	
	@DeleteMapping("/deleteByQuery/{id}")
	public int deleteUserQuery(@PathVariable int id) {
		 return tourService.deleteUserQuery(id);
	}
}