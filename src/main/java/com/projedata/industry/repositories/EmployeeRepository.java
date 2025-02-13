package com.projedata.industry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projedata.industry.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
