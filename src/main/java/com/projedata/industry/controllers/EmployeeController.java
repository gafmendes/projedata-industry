package com.projedata.industry.controllers;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projedata.industry.models.Employee;
import com.projedata.industry.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    private EmployeeService service;
    
    public EmployeeController(EmployeeService service) {
	this.service = service;
    }
    
    @GetMapping
    public List<Employee> listEmployees(){
	return service.listEmployees();
    }
    
    @DeleteMapping("/remove/{name}")
    public void removeEmployee(@PathVariable String name) {
	service.removeEmployee(name);
    }
    
    @PutMapping("/raise-salary")
    public void raiseSalary() {
	service.raiseSalary(new BigDecimal("0.10"));
    }
    
    @GetMapping("/group-by-function")
	public Map<String, List<Employee>> groupByFunction(){
	    return service.groupByFunction();
	}
    
    @GetMapping("/birthdays")
    public List<Employee> listBirthdays(){
	return service.listByBirthdate(Month.OCTOBER, Month.DECEMBER);
    }
    
    @GetMapping("/older")
    public Employee oldestEmployee() {
	return service.oldestEmployee();
    }
    
    @GetMapping("/salary-name")
    public List<Employee> listSalaryByName(){
	return service.ListSalaryByName();
    }
    
    @GetMapping("/total-salaries")
    public BigDecimal calculateTotalSalaries() {
	return service.calculateTotalSalaries();
    }
    
    @GetMapping("/minimum-salaries")
    public Map<String, String> calculateMinimumSalaries(){
	return service.calculateMinimumSalaries(new BigDecimal("1212.00"));
    }


}
