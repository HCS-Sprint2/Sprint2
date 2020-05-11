package com.cap.anurag.service;

import java.util.List;
import java.util.Optional;

import com.cap.anurag.entities.DiagnosticCentre;
import com.cap.anurag.entities.Tests;

public interface AdminService {

	Tests addTest(Tests test);

	List<DiagnosticCentre> getCentres();

	List<Tests> getTests();

	DiagnosticCentre findByCentreName(String centreName);

	Optional<Tests> findBycentreNameAndTestName(String centreName, String testName);

	void save(DiagnosticCentre centre);

	void deleteTestById(String testId);


}