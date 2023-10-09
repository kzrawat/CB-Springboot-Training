package com.cb.employeerestdemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Workout {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String title;
	int cbpm;
	String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCbpm() {
		return cbpm;
	}
	public void setCbpm(int cbpm) {
		this.cbpm = cbpm;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
