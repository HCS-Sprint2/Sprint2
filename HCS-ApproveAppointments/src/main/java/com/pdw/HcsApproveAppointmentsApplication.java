package com.pdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HcsApproveAppointmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcsApproveAppointmentsApplication.class, args);
	}

}
