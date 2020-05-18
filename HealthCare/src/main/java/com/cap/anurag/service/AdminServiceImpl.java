package com.cap.anurag.service;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.anurag.dao.AdminDao;
import com.cap.anurag.entities.DiagnosticCentre;
import com.cap.anurag.entities.Test;
@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
    AdminDao dao;
	
	private Random rand = new Random();
	private String centreId;
	
	@Override
	public DiagnosticCentre addCentre(DiagnosticCentre diagnosticCentre) {
		centreId=Integer.toString(rand.nextInt(1000));
		diagnosticCentre.setCentreId(centreId);
		
		Test test = new Test();
		test.setTestId("ab");
		test.setTestName("Blood group");
		Test test2 = new Test();
		test2.setTestId("ac");
		test2.setTestName("Blood pressure");
		Test test3 = new Test();
		test3.setTestId("ad");
		test3.setTestName("Blood sugar");
		diagnosticCentre.addTest(test);
		diagnosticCentre.addTest(test2);
		diagnosticCentre.addTest(test3);
		
		return dao.save(diagnosticCentre);
	}

	@Override
	public String getCentre(String centreName) {
		return dao.getCentre(centreName);
	}
	@Override
	public String getCentreId(String centreId) {
		return dao.getCentreId(centreId);
	}
	
	@Override
	public void deleteCentreById(String centreId) {
		dao.delete(centreId);
		
	}

	@Override
	public List<DiagnosticCentre> getCentres() {
		return dao.findAll();
	}

	@Override
	public Boolean getDetails(String centreId) {
		return dao.exists(centreId);
	}

	

}
