package com.example.workoutdetailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WorkoutDetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutDetailServiceApplication.class, args);
	}

}
