package org.nagarro.repository;

import java.util.List;

import org.nagarro.model.Employee;

public interface EmployeeRepository {

	
	List<Employee> findAllEmployees();

	Employee getEmployee(Long employeeCode);

	Employee updateEmployee(Long code, Employee employeeToUpdate);


}