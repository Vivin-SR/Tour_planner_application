package com.project_demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project_demo.model.Tour;
import com.project_demo.repository.TourRepository;
import com.project_demo.service.TourService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TourServiceImpl implements TourService {
    @Autowired
	private TourRepository tourRepository;
    
	@Override
	public boolean adduser(Tour tour) {
		// TODO Auto-generated method stub
		boolean userExists = tourRepository.existsByEmail(tour.getEmail());
		if(!userExists)
		{
			tourRepository.save(tour);
			return true;
		}else {
			
			return false;
		}
	}
	
	@Override
	public List<Tour> getUser() {
		// TODO Auto-generated method stub
		return tourRepository.findAll();
	}
	
	@Override
	public boolean updateuser(Long id,Tour tour) {
		
		Optional<Tour>existingUserOptional =tourRepository.findById(id);
		
		if(existingUserOptional.isPresent()) {
		Tour userExists=existingUserOptional.get();
		userExists.setName(tour.getName());
		userExists.setEmail(tour.getEmail());
		userExists.setNoOfPersons(tour.getNoOfPersons());
		userExists.setTourMonth(tour.getTourMonth());
		tourRepository.save(userExists);
		return true;
	}else {
		return false;
	}

}
	@Override
	public boolean deleteUser(Long id) {
		Optional<Tour>existingUserOptional=tourRepository.findById(id);
		if(existingUserOptional.isPresent()) {
			tourRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Page<Tour> getAllUser(PageRequest pageRequest) {
		return tourRepository.findAll(pageRequest);
	}

	@Override
	public int updateUserQuery(int noOfPersons, int id) {
		return tourRepository.updateUserQuery(noOfPersons, id);
	}

	@Override
	public int deleteUserQuery(int id) {
		return tourRepository.deleteUserQuery(id);
	}

	
}