package com.cap.anurag.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.anurag.entities.DiagnosticCentre;

public interface AdminRepository  extends JpaRepository<DiagnosticCentre, String>{

	DiagnosticCentre findByCentreName(String centreName);


}
