package com.example.workoutdetailservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.workoutdetailservice.controller.entity.WorkoutDetail;
import com.example.workoutdetailservice.repo.WorkoutDetailRepo;

@RestController
@RequestMapping("/app/v1/workoutdetails/")

public class WorkoutDetailController {
	
	@Autowired
	WorkoutDetailRepo wrkdtlrepo;
	
	@PostMapping()
	public void addWorkoutDetail(@RequestBody WorkoutDetail wrkdetail) {
		wrkdtlrepo.save(wrkdetail);
	}
	
	@GetMapping()
	public List<WorkoutDetail> getAllWorkoutdetail(){
		return wrkdtlrepo.findAll();
	}
	
	@GetMapping("{id}")
	public WorkoutDetail getworkoutByID(@PathVariable("id") int id) {
		
		Optional<WorkoutDetail> wrkdtl = wrkdtlrepo.findById(id);
		if(wrkdtl.isPresent()) {
			return wrkdtl.get();
		}
		
		return null;
		
	}
}
