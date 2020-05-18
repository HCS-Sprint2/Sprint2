package com.pdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class HcsUserAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcsUserAppointmentApplication.class, args);
	}
	
	
}
