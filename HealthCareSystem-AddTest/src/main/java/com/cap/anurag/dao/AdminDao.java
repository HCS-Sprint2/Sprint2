package com.cap.anurag.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.anurag.entities.Tests;


public interface AdminDao extends JpaRepository<Tests,String>{

	java.util.Optional<Tests> findBycentreNameAndTestName(String centreName, String testName);

	
	
}
