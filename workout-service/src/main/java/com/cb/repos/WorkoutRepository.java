package com.cb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cb.entities.Workout;



public interface WorkoutRepository extends JpaRepository<Workout, Integer>{

}
