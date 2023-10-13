package com.cb.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cb.dto.Workout;
import com.cb.entities.ActiveWorkout;
import com.cb.repos.ActiveWorkoutRepository;
import com.cb.services.WorkoutService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/api/v1/activeworkouts")
public class ActiveWorkoutController {
	
	@Autowired
	ActiveWorkoutRepository activeWorkoutRepository;
	
	@Autowired
	WorkoutService workoutService;
	
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void addWorkout(@RequestBody ActiveWorkout activeWorkout) {
		
		activeWorkout.setWorkoutDate(LocalDate.now());
		activeWorkout.setStartTime(LocalTime.now());
		
		activeWorkoutRepository.save(activeWorkout);
		
	}
	
	
	@PatchMapping("/{id}")
	public ResponseEntity<ActiveWorkout> endWorkout(@PathVariable("id") int id) {
		Optional<ActiveWorkout> activeWorkoutFound = activeWorkoutRepository.findById(id);
		
//		System.out.println("ActiveWorkout is present" + activeWorkoutFound.isPresent());
		log.debug("ActiveWorkout is present" + activeWorkoutFound.isPresent());
		log.info("ActiveWorkout is present" + activeWorkoutFound.isPresent());
		
		ResponseEntity<ActiveWorkout> re = null;
		
		if(activeWorkoutFound.isPresent()) {
			System.out.println("---- active workout is present-------------");
			ActiveWorkout activeWorkout = activeWorkoutFound.get();
			
			//update end time
			activeWorkout.setEndTime(LocalTime.now());
			
			activeWorkoutRepository.save(activeWorkout);
			re = new ResponseEntity<ActiveWorkout>(activeWorkout, HttpStatus.OK);
			return re;
		}
		System.out.println("---- active workout is not present-------------");
//		return new ResponseEntity( HttpStatus.NOT_FOUND);
//		return ResponseEntity.notFound().build();
		re = new ResponseEntity<ActiveWorkout>(HttpStatus.NOT_FOUND);
		return re;
	}
	
	@GetMapping("/")
	public List<ActiveWorkout> fetchAllActiveWorkouts(){
		return activeWorkoutRepository.findAll();
	}
	
	
	@GetMapping("/feign/{id}")
	public ResponseEntity<ActiveWorkout> fetchActiveWorkoutUsingFeign(@PathVariable("id") int id){
		Optional<ActiveWorkout> activeWorkoutFound = activeWorkoutRepository.findById(id);
		ResponseEntity<ActiveWorkout> re = null;
		if(activeWorkoutFound.isPresent()) {
			System.out.println("---- active workout is present-------------");
			log.debug("ActiveWorkout is present" + activeWorkoutFound.isPresent());
			log.info("ActiveWorkout is present" + activeWorkoutFound.isPresent());
			ActiveWorkout activeWorkout = activeWorkoutFound.get();
			// Declarative .. tools provide Spring cloud -- openfeign
//			Workout workout = workoutServiceProxy.fetchWorkout(activeWorkout.getWorkoutId());
			Workout workout = workoutService.getWorkout(activeWorkout.getWorkoutId());
			activeWorkout.setWorkout(workout);
			
			
			re = new ResponseEntity<ActiveWorkout>(activeWorkout, HttpStatus.OK);
			return re;
		}
		return new ResponseEntity<ActiveWorkout>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ActiveWorkout> fetchActiveWorkout(@PathVariable("id") int id){
		Optional<ActiveWorkout> activeWorkoutFound = activeWorkoutRepository.findById(id);
		ResponseEntity<ActiveWorkout> re = null;
		if(activeWorkoutFound.isPresent()) {
			System.out.println("---- active workout is present-------------");
			ActiveWorkout activeWorkout = activeWorkoutFound.get();
			
			// fetch the workout details running on localhost:8080
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("id", "" + activeWorkout.getWorkoutId());

			
			// call http://localhost:8080/api/v1/workouts/153
			ResponseEntity<Workout> workoutEntity = new RestTemplate().getForEntity("http://localhost:8080/api/v1/workouts/{id}",
					Workout.class, uriVariables);
			
			Workout workout = workoutEntity.getBody();
			System.out.println(workout);
			activeWorkout.setWorkout(workout);
			
			
			re = new ResponseEntity<ActiveWorkout>(activeWorkout, HttpStatus.OK);
			return re;
		}
		return new ResponseEntity<ActiveWorkout>(HttpStatus.NOT_FOUND);
	}
	
	

}
