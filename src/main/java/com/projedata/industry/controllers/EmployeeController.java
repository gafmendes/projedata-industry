package com.projedata.industry.controllers;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projedata.industry.models.Employee;
import com.projedata.industry.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    
    private EmployeeService service;
    
    @Autowired
    public EmployeeController(EmployeeService service) {
	this.service = service;
    }
    
    @GetMapping
    public List<Employee> listEmployees(){
	return service.listEmployees();
    }
    
    @DeleteMapping(value = "/remove/{name}")
    public void removeEmployee(@PathVariable String name) {
	service.removeEmployee(name);
    }
    
    @PutMapping(value = "/raise-salary")
    @ResponseBody
    public List<Employee> raiseSalary(){
	service.raiseSalary();
	return service.listEmployees();
    }
    
    @GetMapping(value = "/group-by-function")
	public Map<String, List<Employee>> groupByFunction(){
	    return service.groupByFunction();
	}
    
    @GetMapping(value = "/birthdays")
    public List<Employee> listBirthdays(){
	return service.listByBirthday(Month.OCTOBER, Month.DECEMBER);
    }
    
    @GetMapping(value = "/older")
    public Employee oldestEmployee() {
	return service.oldestEmployee();
    }
    
    @GetMapping(value = "/salary-name")
    public List<Employee> listSalaryByName(){
	return service.ListSalaryByName();
    }
    
    @GetMapping(value = "/total-salaries")
    public BigDecimal calculateTotalSalaries() {
	return service.calculateTotalSalaries();
    }
    
    @GetMapping(value = "/minimum-salaries")
    public Map<String, BigDecimal> calculateMinimumSalaries(){
	return service.calculateMinimumSalaries(new BigDecimal("1212.00"));
    }


}
