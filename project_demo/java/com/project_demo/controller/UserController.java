package com.project_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_demo.model.Tour;
import com.project_demo.service.TourService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
@Tag(name = "user")
public class UserController {
	
	@Autowired
	private TourService tourService;
	@PostMapping("/signup")
	public ResponseEntity<String> addUser(@RequestBody Tour tour){
		boolean isDataAdded = tourService.AddUser(tour);
		if (isDataAdded) {
			return ResponseEntity.status(200).body("User added successfully!");
		} else {
			return ResponseEntity.status(404).body("Something went wrong!");
		}
	}
	
	@PostMapping("/login") 
	public ResponseEntity<String>getUser(@RequestBody Tour tour){
		boolean isDataGet=tourService.GetUser(tour);
		if(isDataGet) {
			return ResponseEntity.status(200).body("Logged in successfully!");
		}else {
			return ResponseEntity.status(404).body("User not found!");
		}
	}
}