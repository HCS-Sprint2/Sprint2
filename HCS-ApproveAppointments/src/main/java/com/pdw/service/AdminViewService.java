package com.pdw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdw.daoI.AppointmentDaoI;
import com.pdw.entity.Appointment;

@Service
public class AdminViewService implements AdminViewServiceI {

	@Autowired
	AppointmentDaoI appointmentDao;

	@Override
	public List<Appointment> AppointmentList() { // fetches the appointments made by the user by using
		// data jpa find all method
		List<Appointment> appointmentList = appointmentDao.findAll();
		return appointmentList;
	}

//update method is used to approve the appointments made by the user
	@Override
	public String approveAppointment(Appointment appointment) {
		appointmentDao.save(appointment);
		return "Appointment is updated";
	}

}
