package com.cb.employeerestdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cb.employeerestdemo.entities.Employee;
import com.cb.employeerestdemo.repos.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
//	@RequestMapping(path="/employees", method= RequestMethod.POST)
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee employee) {
		// save to databasess
		employeeRepository.save(employee);
		
	}
	
	@GetMapping("/employees")
	public List<Employee> fetchAllEmployees(){
		return employeeRepository.findAll();
	}
	

}
