package com.projedata.industry.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.projedata.industry.models.Employee;
import com.projedata.industry.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    public EmployeeService(EmployeeRepository repository) {
	this.repository = repository;
    }

    public List<Employee> listEmployees() {
	return repository.findAll();

    }

    public void removeEmployee(String name) {
	List<Employee> employees = repository.findAll();
	for (Employee employee : employees) {
	    if (employee.getName().equalsIgnoreCase(name)) {
		repository.delete(employee);
		break;
	    }

	}
    }
    
    public void raiseSalary(BigDecimal percentage) {
	List<Employee> employees = repository.findAll();
	for (Employee employee : employees) {
	    BigDecimal actualSalary = employee.getSalary();
	    BigDecimal increase = actualSalary.multiply(BigDecimal.ONE.add(percentage));
	    employee.setSalary(increase);
	}
	
	repository.saveAll(employees);
    }
    
    public Map<String, List<Employee>> groupByFunction(){
	Map<String, List<Employee>> result = new HashMap<>();
	List<Employee> employees = repository.findAll();
	
	for(Employee employee : employees) {
	    String function = employee.getFunction();
	    if(!result.containsKey(function)) {
		result.put(function, new ArrayList<>());
	    }
	    result.get(function).add(employee);
	}
	return result;
    }
    
    public List<Employee> listByBirthday(Month... month){
	List<Employee> employees = repository.findAll();
	List<Employee> result = new ArrayList<>();
	Set<Month> monthSet = new HashSet<>(Arrays.asList(month));
	
	for(Employee employee : employees) {
	    if(monthSet.contains(employee.getBirthday().getMonth())) {
		result.add(employee);
	    }
	}
	return result;
    }
    
    
    public Employee oldestEmployee() {
	List<Employee> employees = repository.findAll();
	Employee older = null;
	
	for(Employee employee : employees) {
	    if(older == null || employee.getBirthday().isBefore(older.getBirthday())) {
		older = employee;
	    }
	}
	
	return older;
    }
    
    public List<Employee> ListSalaryByName(){
	List<Employee> employees = repository.findAll();
	employees.sort(new Comparator<Employee>() {
	@Override
	public int compare(Employee e1, Employee e2) {
	    return e1.getName().compareTo(e2.getName());
	}
	});
	
	return employees;
    }
    
    public BigDecimal calculateTotalSalaries() {
	BigDecimal totalSalaries = BigDecimal.ZERO;
	List<Employee> employees = repository.findAll();
	
	for(Employee employee : employees) {
	    totalSalaries = totalSalaries.add(employee.getSalary());
	}
	return totalSalaries;
    }

    public Map<String, String> calculateMinimumSalaries(BigDecimal minimumSalaries){
	Map<String, String> result = new HashMap<>();
	List<Employee> employees = repository.findAll();
	
	for(Employee employee : employees) {
	    BigDecimal salary = employee.getSalary();
	    String salaryMinimumFormatted = decimalFormat.format(salary.divide(minimumSalaries, 2, RoundingMode.HALF_UP));
	    result.put(employee.getName(), salaryMinimumFormatted);
	}
	
	return result;
    }
    
}
