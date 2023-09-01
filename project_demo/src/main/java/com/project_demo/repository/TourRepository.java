package com.project_demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project_demo.model.Tour;

import jakarta.transaction.Transactional;



public interface TourRepository extends JpaRepository<Tour,Integer>{

	boolean existsByEmail(String email);
	Optional<Tour>findById(Long id);
	Optional<Tour>deleteById(Long id);
	
	@Modifying
	@Transactional
	@Query("update Tour t set t.noOfPersons = :noOfPersons where t.id=:id")
	int updateUserQuery(@Param("noOfPersons") int noOfPersons,@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value="delete from tour where id = ?1" ,nativeQuery=true)
	int deleteUserQuery(int id);

}