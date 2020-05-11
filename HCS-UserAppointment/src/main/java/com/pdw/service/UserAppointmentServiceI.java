package com.pdw.service;


import java.util.List;

import com.pdw.entity.Appointment;
import com.pdw.entity.DiagnosticCentre;
import com.pdw.entity.Test;


public interface UserAppointmentServiceI {
	List<DiagnosticCentre> DiagnosticCenterList();
	List<Test> TestsList(String centreId);
	String makeAppointment(Appointment app);
    Boolean userIdFound(String userId);
	List<Appointment> AppointmentList();

}
