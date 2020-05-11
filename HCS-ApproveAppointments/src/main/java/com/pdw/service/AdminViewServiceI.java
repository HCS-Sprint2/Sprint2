package com.pdw.service;

import java.util.List;

import com.pdw.entity.Appointment;

public interface AdminViewServiceI {
	List<Appointment> AppointmentList();

	String approveAppointment(Appointment app);

}
