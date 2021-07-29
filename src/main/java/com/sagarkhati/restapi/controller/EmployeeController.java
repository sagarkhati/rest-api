package com.sagarkhati.restapi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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
	public EntityModel<Employee> getEmployee(@PathVariable int id) {
		Employee emp = empService.getEmployee(id);

		return EntityModel.of(emp, linkTo(methodOn(EmployeeController.class).getEmployee(id)).withSelfRel(),
				linkTo(methodOn(EmployeeController.class).getAllEmployee()).withRel("employees"));
	}

	@GetMapping("/employees")
	public CollectionModel<EntityModel<Employee>> getAllEmployee() {
		List<Employee> employees = empService.getAllEmployee();

		List<EntityModel<Employee>> emps = employees.stream()
				.map(employee -> EntityModel.of(employee,
						linkTo(methodOn(EmployeeController.class).getEmployee(employee.getEmpId())).withSelfRel()))
				.collect(Collectors.toList());

		return CollectionModel.of(emps, linkTo(methodOn(EmployeeController.class).getAllEmployee()).withSelfRel());
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
