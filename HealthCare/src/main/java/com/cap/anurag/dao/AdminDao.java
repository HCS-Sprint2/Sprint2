package com.cap.anurag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cap.anurag.entities.DiagnosticCentre;

public interface AdminDao extends JpaRepository<DiagnosticCentre, String> {
	@Query("select d.centreName from DiagnosticCentre d where d.centreName=?1")
	String getCentre(String centreName);

	@Query("select d.centreId from DiagnosticCentre d where d.centreId=?1")
	String getCentreId(String centreId);
}
