package com.cap.anurag.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.anurag.dao.AdminDao;
import com.cap.anurag.entities.DiagnosticCentre;
@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
    AdminDao dao;
	
	@Override
	public DiagnosticCentre addCentre(DiagnosticCentre diagnosticCentre) {
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
