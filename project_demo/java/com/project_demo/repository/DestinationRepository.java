package com.project_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_demo.model.Destinations;

public interface DestinationRepository extends JpaRepository<Destinations,Integer>{

}
