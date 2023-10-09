package com.cb.employeerestdemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cb.employeerestdemo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
