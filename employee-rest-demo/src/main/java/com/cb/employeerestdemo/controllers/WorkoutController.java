package com.cb.employeerestdemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cb.employeerestdemo.entities.Workout;
import com.cb.employeerestdemo.repos.WorkoutRepository;

@RestController
@RequestMapping("/api/v1/workouts")
public class WorkoutController {
	
	@Autowired
	WorkoutRepository workoutRepository;
	
//	@RequestMapping(path="/employees", method= RequestMethod.POST)
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void addWorkout(@RequestBody Workout workout) {
		// save to databasess
		workoutRepository.save(workout);
		
	}
	
	@GetMapping("/")
	public List<Workout> fetchAllWorkouts(){
		return workoutRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Workout> fetchAWorkout(@PathVariable("id") int workoutId){
		
		Optional<Workout> workoutFound = workoutRepository.findById(workoutId);
		ResponseEntity<Workout> re = null;
		if(workoutFound.isPresent()) {
			Workout workout = workoutFound.get();
			re = new ResponseEntity<Workout>(workout, HttpStatus.OK);
			return re;
		}
		re = new ResponseEntity<Workout>(HttpStatus.NOT_FOUND);
		return re;
	}
	

}
