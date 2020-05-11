package com.cap.anurag.service;

import java.util.List;

import com.cap.anurag.entities.DiagnosticCentre;

public interface AdminService {
	
	DiagnosticCentre addCentre(DiagnosticCentre diagnosticCentre);

	String getCentre(String centreName);

	void deleteCentreById(String centreId);

	List<DiagnosticCentre> getCentres();

	Boolean getDetails(String centreId);

	String getCentreId(String centreId);

}
