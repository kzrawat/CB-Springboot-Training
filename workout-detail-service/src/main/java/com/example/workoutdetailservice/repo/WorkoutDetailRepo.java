package com.example.workoutdetailservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workoutdetailservice.controller.entity.WorkoutDetail;

public interface WorkoutDetailRepo extends JpaRepository<WorkoutDetail, Integer> {

}
