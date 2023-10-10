package com.cb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cb.entities.ActiveWorkout;

public interface ActiveWorkoutRepository extends JpaRepository<ActiveWorkout, Integer>{

}
