package com.pdw.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdw.entity.Appointment;
import com.pdw.service.AdminViewServiceI;

@RestController
@RequestMapping("/Admin")
@CrossOrigin("http://localhost:4200")
public class ApproveAppointmentsController {
	//Controller class fetches the method from service interface which enables the admin to
	//approve the scheduled appointments by updating the appointment object
	
	
	@Autowired    // service interface object
	AdminViewServiceI adminViewService;
	
	 @PutMapping("/approveAppointment")
	 public String updateAppointment(@RequestBody Appointment appointment) {
		 String updateMessage =  adminViewService.approveAppointment(appointment);
		 return updateMessage;
	 }
	 
	 
}
