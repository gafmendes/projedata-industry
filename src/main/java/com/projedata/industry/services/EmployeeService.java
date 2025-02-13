package com.projedata.industry.services;

import java.text.DecimalFormat;
import java.util.List;

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

    public List<Employee> listarFuncionarios() {
	return repository.findAll();

    }
}
