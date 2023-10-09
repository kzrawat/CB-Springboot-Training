package com.cb.restdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {
	
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello everyone!";
	}
	
	@RequestMapping(path = "/employee", method = RequestMethod.GET)
	public Employee fetchEmployee() {
		return new Employee(2, "Ravi", 34343.34);
	}
	

}
