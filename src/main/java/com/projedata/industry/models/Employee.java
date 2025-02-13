package com.projedata.industry.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Employee extends People {
    
    private BigDecimal salary;
    private String function;
    
    public Employee() {
	
    }
    
    public Employee(String name, LocalDate birthdate, BigDecimal salary, String function) {
        super(name, birthdate);
        this.salary = salary;
        this.function = function;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
    
    

}
