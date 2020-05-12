package com.pdw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdw.daoI.AppointmentDaoI;
import com.pdw.daoI.CenterDaoI;
import com.pdw.daoI.TestDaoI;
import com.pdw.entity.Appointment;
import com.pdw.entity.DiagnosticCentre;
import com.pdw.entity.Test;
@Service
public class UserAppointmentService implements UserAppointmentServiceI  {

	
	@Autowired
	TestDaoI testDao;
	
	@Autowired
	AppointmentDaoI appointmentDao;
	@Autowired
	CenterDaoI centerListDao;
	
	@Override
	public List<DiagnosticCentre> DiagnosticCenterList() {
		List<DiagnosticCentre> CenterList=centerListDao.findAll();
		return CenterList;
	}

	
	@Override
	public List<Test> TestsList(String centreId) {
		List<Test> testList=centerListDao.getOne(centreId).getListOfTests();
		return testList;
	}
	
	public Boolean userIdFound(String userId){
		List<String> exists=appointmentDao.checkUserIdEXists(userId);
		Boolean value=exists.isEmpty();
	return value;
	}

	@Override
	public String makeAppointment(Appointment app) {
		@SuppressWarnings("unused")
		Appointment updatedApp= appointmentDao.save(app);
		
		return "Appointment is registered, please await for confirmation";
	}


	@Override
	public List<Appointment> AppointmentList() {
		List<Appointment> appList=appointmentDao.findAll(); 
		// using data jpa find all method to get the values
		return appList;
	}


	}

