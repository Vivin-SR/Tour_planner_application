package com.project_demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.project_demo.model.Tour;


public interface TourService {
	
public boolean adduser(Tour tour);
public List<Tour> getUser();
public boolean updateuser(Long id, Tour tour);
boolean deleteUser(Long id);
public Page<Tour> getAllUser(PageRequest pageRequest);
public int updateUserQuery(int noOfPersons, int id);
public int deleteUserQuery(int id);
}