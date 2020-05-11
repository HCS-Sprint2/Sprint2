package com.pdw;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pdw.entity.Appointment;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestMakeAppointments {
	@Test
	public void MakeAppointmentsSuccess() throws URISyntaxException{
		RestTemplate rest=new RestTemplate();
		final String baseUrl="http://localhost:"+1111+"/User/makeAppointment";
		URI uri=new URI(baseUrl);
		
		Appointment appointments=new Appointment();
		appointments.setApproved(true);
		appointments.setAppointmentId(1234);
		appointments.setCenter("Madhapur Diagnostics");
		appointments.setDateTimeSlot("2020-06-13T04:30");
		appointments.setTest("X Ray Test");
		appointments.setUserId("12");
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		HttpEntity<Appointment> request=new HttpEntity<>(appointments,headers);
		
		ResponseEntity<String> result=rest.postForEntity(uri,request,String.class);;
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertNotNull(appointments);
	
	}
	
	@Test
	public void MakeAppointmentsFail() throws URISyntaxException{
		RestTemplate rest=new RestTemplate();
		final String baseUrl="http://localhost:"+1111+"/User/makeAppointment";
		URI uri=new URI(baseUrl);
		
		Appointment appointments=new Appointment();
		appointments.setApproved(true);
		HttpEntity<Appointment> request=new HttpEntity<>(appointments);
		
		ResponseEntity<String> result=rest.postForEntity(uri,request,String.class);
		Assert.assertEquals(400, result.getStatusCodeValue());
		Assert.assertNull(appointments);
	
	}

}
