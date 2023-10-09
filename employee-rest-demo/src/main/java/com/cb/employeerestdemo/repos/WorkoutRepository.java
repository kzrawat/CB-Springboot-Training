package com.cb.employeerestdemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cb.employeerestdemo.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{

}
