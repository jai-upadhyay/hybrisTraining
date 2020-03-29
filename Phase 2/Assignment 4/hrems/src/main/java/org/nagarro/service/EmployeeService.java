package org.nagarro.service;

import java.util.List;

import org.nagarro.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployee(long employeeCode);

	List<Employee> updateEmployee(Employee employee);
}
