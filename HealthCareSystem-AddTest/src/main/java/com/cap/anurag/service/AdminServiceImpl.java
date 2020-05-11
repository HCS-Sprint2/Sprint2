package com.cap.anurag.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.anurag.dao.AdminDao;
import com.cap.anurag.dao.AdminRepository;
import com.cap.anurag.entities.DiagnosticCentre;
import com.cap.anurag.entities.Tests;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;

	@Autowired
	AdminRepository repo;

	@Override
	public Tests addTest(Tests test) {
		return dao.save(test);
	}

	@Override
	public List<Tests> getTests() {
		return dao.findAll();

	}

	@Override
	public List<DiagnosticCentre> getCentres() {
		return repo.findAll();
	}


	@Override
	public DiagnosticCentre findByCentreName(String centreName) {
		return repo.findByCentreName(centreName);
	}

	@Override
	public Optional<Tests> findBycentreNameAndTestName(String centreName, String testName) {
		return dao.findBycentreNameAndTestName(centreName, testName);
	}

	@Override
	public void save(DiagnosticCentre centre) {
		repo.save(centre);
		
	}

	@Override
	public void deleteTestById(String testId) {
		dao.delete(testId);
		
	}

}
