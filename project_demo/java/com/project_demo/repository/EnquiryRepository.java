package com.project_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_demo.model.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry,Integer>{

}
