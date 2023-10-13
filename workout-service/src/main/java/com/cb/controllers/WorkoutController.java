package com.cb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cb.entities.Category;
import com.cb.entities.Workout;
import com.cb.repos.CategoryRepository;
import com.cb.repos.WorkoutRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/workouts")
public class WorkoutController {
	
	@Autowired
	WorkoutRepository workoutRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Value("${server.port}")
	String port;
	
//	@RequestMapping(path="/employees", method= RequestMethod.POST)
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void addWorkout(@RequestBody Workout workout) {
		// save to databasess
		
		
		// check if category already exists
		if(workout.getCategory().getId() > 0) {
			Optional<Category> categoryFound =categoryRepository.findById(workout.getCategory().getId());
			if(categoryFound.isPresent()) {
				workout.setCategory(categoryFound.get());
			}
		}
		
		workoutRepository.save(workout);
		
	}
	
	@GetMapping("/")
	public List<Workout> fetchAllWorkouts(){
		return workoutRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Workout> fetchAWorkout(@PathVariable("id") int workoutId){
		
		log.info("In workout service ..... " + workoutId);
		
		Optional<Workout> workoutFound = workoutRepository.findById(workoutId);
		ResponseEntity<Workout> re = null;
		if(workoutFound.isPresent()) {
			Workout workout = workoutFound.get();
			workout.setPort(port);
			re = new ResponseEntity<Workout>(workout, HttpStatus.OK);
			return re;
		}
		re = new ResponseEntity<Workout>(HttpStatus.NOT_FOUND);
		return re;
	}
	

}
