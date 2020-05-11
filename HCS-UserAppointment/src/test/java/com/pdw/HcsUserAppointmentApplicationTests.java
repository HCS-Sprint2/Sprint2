package com.pdw;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.pdw.entity.DiagnosticCentre;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class HcsUserAppointmentApplicationTests {
 
	@Test
	public void CenterListSuccess() throws URISyntaxException{
		RestTemplate rest=new RestTemplate();
		final String baseUrl="http://localhost:"+1111+"/User/FetchCenterList";
		URI uri=new URI(baseUrl);
		
		ResponseEntity<DiagnosticCentre[]> result=rest.getForEntity(uri,DiagnosticCentre[].class);
		DiagnosticCentre[] diagnosticCenter=result.getBody();
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertNotNull(diagnosticCenter);
	
	}
	
	@Test
	public void CenterListFail() throws URISyntaxException{
		RestTemplate rest=new RestTemplate();
		final String baseUrl="http://localhost:"+1111+"/User/FetchCenterList";
		URI uri=new URI(baseUrl);
		
		ResponseEntity<DiagnosticCentre[]> result=rest.getForEntity(uri,DiagnosticCentre[].class);
		Assert.assertEquals(400, result.getStatusCodeValue());
	
	}

}

