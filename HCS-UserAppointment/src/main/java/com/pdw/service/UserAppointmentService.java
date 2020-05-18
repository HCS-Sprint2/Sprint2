package com.pdw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdw.daoI.AppointmentDaoI;
import com.pdw.daoI.CenterDaoI;
import com.pdw.entity.Appointment;
import com.pdw.entity.DiagnosticCentre;
import com.pdw.entity.Test;
@Service
public class UserAppointmentService implements UserAppointmentServiceI  {

	
	
	@Autowired
	AppointmentDaoI appointmentDao;
	@Autowired
	CenterDaoI centerListDao;
	
	//Fetches all the diagnostic centers from the centers table to display by using find all method
	@Override
	public List<DiagnosticCentre> DiagnosticCenterList() {
		List<DiagnosticCentre> CenterList=centerListDao.findAll();
		return CenterList;
	}

	//Fetching all the Tests available from the respective selected diagnostic Centers
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

	//Creating a new appointment 
	@Override
	public String makeAppointment(Appointment appointment) {
		 appointmentDao.save(appointment);
		
		return "Appointment is registered, please await for confirmation";
	}


	@Override
	public List<Appointment> AppointmentList() {
		List<Appointment> appointmentList=appointmentDao.findAll(); 
		// using data jpa find all method to get the details of appointments made by the users
		return appointmentList;
	}


	}

