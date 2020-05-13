package com.pdw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pdw.entity.Appointment;
import com.pdw.entity.DiagnosticCentre;
import com.pdw.entity.Test;
import com.pdw.exceptionalHandling.DuplicateUserIdException;
import com.pdw.service.UserAppointmentServiceI;

@RestController
@RequestMapping("/User")
@CrossOrigin("http://localhost:4200")
public class UserAppointmentController {

	@Autowired
	UserAppointmentServiceI appointmentServiceI;

//Fetches service interface method which gets all the centers available in the center table 
	@GetMapping("/FetchCenterList")
	public List<DiagnosticCentre> getCenterList() {
		List<DiagnosticCentre> center = appointmentServiceI.DiagnosticCenterList();
		return center;
	}

	@GetMapping("/FetchTestList/{centerId}")
	public List<Test> getTestList(@PathVariable("centerId") String centerId) {
		List<Test> diagnosticCenter = appointmentServiceI.TestsList(centerId);
		System.out.println(diagnosticCenter);
		return diagnosticCenter;
	}

//Fetches make appointment method in service interface only if the user hasn't made any appointments before
	@PostMapping("/makeAppointment")
	public ResponseEntity<Boolean> updateAppointment(@RequestBody Appointment appointment) {
		Boolean exists = appointmentServiceI.userIdFound(appointment.getUserId());
		if (exists) {
			System.out.println(exists);
			appointmentServiceI.makeAppointment(appointment);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} else {
//Exceptional Handling to check if the user has already made an appointment
// ensures one user makes only one appointment
			throw new DuplicateUserIdException("Sorry! User Id exists");
		}
	}
    //For duplicate user Id
	@ExceptionHandler(DuplicateUserIdException.class)
	public ResponseEntity<Boolean> userFound(DuplicateUserIdException exception) {
		return new ResponseEntity<>(false, HttpStatus.OK);
	}

	// displaying all the appointment details from the appointment table
	@GetMapping("/FetchAppList") 
	public List<Appointment> getAppointmentList() {
		List<Appointment> center = appointmentServiceI.AppointmentList();
		return center;
	}

}
