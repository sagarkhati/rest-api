package com.sagarkhati.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagarkhati.restapi.entity.Employee;
import com.sagarkhati.restapi.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return empService.getEmployee(id);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return empService.getAllEmployee();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee emp) {
		return empService.createEmployee(emp);
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return empService.updateEmployee(emp);
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable int id) {
		empService.deleteEmployee(id);
	}
}
