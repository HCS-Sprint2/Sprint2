package com.cap.anurag;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cap.anurag.entities.DiagnosticCentre;

@SpringBootTest
class HealthCareApplicationTests {
	@Test
	public void testGetDiagnosticCentreListSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 7871 + "/DiagnosticCentre/create";
		URI uri = new URI(baseUrl);

		DiagnosticCentre diagnosticCentre = new DiagnosticCentre();
		diagnosticCentre.setCentreId("123");
		diagnosticCentre.setCentreName("dnkd");// Add new every time

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		HttpEntity<DiagnosticCentre> request = new HttpEntity<>(diagnosticCentre, headers);

		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertNotNull(result);
	}

	@Test
	public void testGetDiagnosticCentreListUnsuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 7871 + "/DiagnosticCentre/create";
		URI uri = new URI(baseUrl);

		DiagnosticCentre diagnosticCentre = new DiagnosticCentre();
		diagnosticCentre.setCentreId("123");
		diagnosticCentre.setCentreName("Abcd");

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		HttpEntity<DiagnosticCentre> request = new HttpEntity<>(diagnosticCentre, headers);

		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		Assert.assertEquals(302, result.getStatusCodeValue());
		Assert.assertNotNull(result);
	}

	@Test
	public void testDeleteDiagnosticCentreListSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:7871/DiagnosticCentre/delete/925";// Enter present id
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, null, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
	}

}
