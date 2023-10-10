package com.cb.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cb.dto.Workout;

@FeignClient(name="workout-service", url="http://localhost:8080")
public interface WorkoutServiceProxy {
	
	@GetMapping(path="/api/v1/workouts/{id}")
	public Workout fetchWorkout(@PathVariable("id") int id);

}
