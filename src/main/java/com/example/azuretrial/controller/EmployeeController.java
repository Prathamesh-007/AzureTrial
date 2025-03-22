package com.example.azuretrial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.azuretrial.entity.Employee;
import com.example.azuretrial.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	
	@RequestMapping("/getAll")
	public List<Employee> getAll() {
		List<Employee> list = es.getAllEmployees();
		for(Employee employee: list) {
			System.out.println(employee);
		}
		
		return list;
	}
	
	@RequestMapping("/insert")
	public void insert(@RequestParam Integer id, @RequestParam String name) {
		Employee e = new Employee(id, name);
		System.out.println(e);
		es.addEmployee(e);
	}
	
	@GetMapping("/insert")
	public void getMappingInsert(@RequestBody Employee e) {
		System.out.println(e);
		es.addEmployee(e);
	}
}
