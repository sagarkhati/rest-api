package com.sagarkhati.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagarkhati.restapi.entity.Employee;
import com.sagarkhati.restapi.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	public Employee getEmployee(int id) {
		Optional<Employee> emp = empRepo.findById(id);
		return emp.get();
	}

	public List<Employee> getAllEmployee() {
		List<Employee> empList = empRepo.findAll();
		return empList;
	}

	public Employee createEmployee(Employee emp) {
		Employee employee = empRepo.save(emp);
		return employee;
	}

	public Employee updateEmployee(Employee emp) {
		Employee employee = empRepo.save(emp);
		return employee;
	}

	public void deleteEmployee(int id) {
		empRepo.deleteById(id);
	}

}
