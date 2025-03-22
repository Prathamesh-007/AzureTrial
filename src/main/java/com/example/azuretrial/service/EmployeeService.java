package com.example.azuretrial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.azuretrial.entity.Employee;
import com.example.azuretrial.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee findEmployee(Integer id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public void addEmployee(Integer id, String name) {
		employeeRepository.save(new Employee(id, name));
	}
	
	public void addEmployee(Employee e) {
		employeeRepository.save(e);
	}

}
