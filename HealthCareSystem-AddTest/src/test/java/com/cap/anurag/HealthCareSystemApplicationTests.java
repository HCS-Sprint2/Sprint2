package com.cap.anurag;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cap.anurag.entities.DiagnosticCentre;
import com.cap.anurag.entities.Tests;

@SpringBootTest
public class HealthCareSystemApplicationTests {
	
	@Test
	public void testGetTestListSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 8033 + "/Test/create";
		URI uri = new URI(baseUrl);
		Tests test = new Tests();
		test.setTestId(null);
		test.setTestName("blood");
		DiagnosticCentre diagnosticCentre = new DiagnosticCentre();
		diagnosticCentre.setCentreId(null);
		diagnosticCentre.setCentreName("Hyderabad");// Add new every time
		test.setCentre(diagnosticCentre);
		test.setCentreName(null);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		HttpEntity<Tests> request = new HttpEntity<>(test, headers);

		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
	}	@Test
	public void testGetTestListUnsuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 8033 + "/Test/create";
		URI uri = new URI(baseUrl);
		Tests test = new Tests();
		test.setTestId(null);
		test.setTestName("blood");
		DiagnosticCentre diagnosticCentre = new DiagnosticCentre();
		diagnosticCentre.setCentreId(null);
		diagnosticCentre.setCentreName("Hyderabad");// Add new every time
		test.setCentre(diagnosticCentre);
		test.setCentreName(null);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		HttpEntity<Tests> request = new HttpEntity<>(test, headers);

		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		Assert.assertNull(result);
	}
	@Test
	public void testDeleteDiagnosticCentreListSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8033/Test/delete/db3d2b4b-571a-4ec8-9e97-848651a14f95";//Enter present id
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, null, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
	}


}