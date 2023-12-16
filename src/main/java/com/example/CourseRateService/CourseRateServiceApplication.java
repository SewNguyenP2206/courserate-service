package com.example.CourseRateService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CourseRateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseRateServiceApplication.class, args);
	}

}
