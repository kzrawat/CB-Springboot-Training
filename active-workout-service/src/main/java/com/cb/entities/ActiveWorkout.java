package com.cb.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ActiveWorkout {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int workoutId;
	
	LocalDate workoutDate;
	LocalTime startTime;
	LocalTime endTime;
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
	
	
	
}
