package com.cb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ActiveWorkoutServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveWorkoutServiceApplication.class, args);
	}

}
