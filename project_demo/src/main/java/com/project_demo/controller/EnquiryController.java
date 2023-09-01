package com.project_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/enquiry")
public class EnquiryController {
	public ResponseEntity<String>Sample(){
		return ResponseEntity.status(200).body("Hello !");
	}
}
