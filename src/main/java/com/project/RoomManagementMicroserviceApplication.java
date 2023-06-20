package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class RoomManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomManagementMicroserviceApplication.class, args);
	}
	
	@Bean
	protected RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
