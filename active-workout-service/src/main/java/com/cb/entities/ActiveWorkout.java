package com.cb.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cb.dto.Workout;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class ActiveWorkout {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int workoutId;
	
	LocalDate workoutDate;
	LocalTime startTime;
	LocalTime endTime;
	
	@Transient
	Workout workout;
	
	
	public Workout getWorkout() {
		return workout;
	}
	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
	public int getId() {
		return id;
		
//		LocalDate.now()
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getWorkoutDate() {
		return workoutDate;
	}
	public void setWorkoutDate(LocalDate workoutDate) {
		this.workoutDate = workoutDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public int getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}
	
	
	
}
