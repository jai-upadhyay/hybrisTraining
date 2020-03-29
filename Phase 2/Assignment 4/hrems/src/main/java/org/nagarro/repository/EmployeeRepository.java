package org.nagarro.repository;

import java.util.List;

import org.nagarro.model.Employee;
import org.springframework.stereotype.Repository;
@Repository()
public interface EmployeeRepository {
	List<Employee> getAllEmployees();

	Employee getEmployee(long employeeCode);

	List<Employee> updateEmployee(Employee employee);
}
