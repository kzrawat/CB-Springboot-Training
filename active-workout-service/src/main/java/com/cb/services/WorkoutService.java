package com.cb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.controller.WorkoutServiceProxy;
import com.cb.dto.Workout;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WorkoutService {

	@Autowired
	WorkoutServiceProxy workoutServiceProxy;
	
	
	@HystrixCommand(fallbackMethod = "handleError")
	public Workout getWorkout(int workoutId) {
		Workout workout = workoutServiceProxy.fetchWorkout(workoutId);
		return workout;
	}
	
	public Workout handleError(int workoutId) {
		System.out.println("***** handle error method*****");
		return new Workout(12, "Cardio", 14, "good for health....");
	}
}
