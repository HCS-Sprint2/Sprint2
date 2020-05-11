package com.cap.anurag.controller;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cap.anurag.entities.DiagnosticCentre;
import com.cap.anurag.exception.RecordFoundException;
import com.cap.anurag.exception.RecordNotFoundException;
import com.cap.anurag.service.AdminService;

@RestController
@RequestMapping("/DiagnosticCentre")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	AdminService service;

	private Random rand = new Random();

	// Fetches Center Details and maps
	@PostMapping("/create")
	public ResponseEntity<Boolean> create(@RequestBody(required=false) DiagnosticCentre diagnosticCentre) {
		if(diagnosticCentre==null){
            throw new RuntimeException("DiagnosticCentre is null");
        }
		String centreId=Integer.toString(rand.nextInt(1000));
		String centre = service.getCentreId(centreId);
		String centreName = service.getCentre(diagnosticCentre.getCentreName());
		if (centreName != null || centre != null) {
			throw new RecordFoundException("CentreName found");
		} else {
			diagnosticCentre.setCentreId(centreId);
			service.addCentre(diagnosticCentre);
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
	}

	// fetches center id for deleting
	@DeleteMapping("/delete/{centreId}")
	public ResponseEntity<Boolean> deleteCentreById(@PathVariable("centreId") String centreId) {
		Boolean data = service.getDetails(centreId);
		if (Boolean.TRUE.equals(data)) {
			service.deleteCentreById(centreId);
			return new ResponseEntity<>(true, new HttpHeaders(), HttpStatus.OK);
		} else
			throw new RecordNotFoundException("Centre Name found");
	}
	//view
	@GetMapping("/find")
	public ResponseEntity<List<DiagnosticCentre>> getAllCentres() {
		List<DiagnosticCentre> list = service.getCentres();
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}


	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> userNotFound(RecordNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RecordFoundException.class)
	public ResponseEntity<Boolean> userNotFound(RecordFoundException e) {
		return new ResponseEntity<>(false, HttpStatus.OK);
	}
}