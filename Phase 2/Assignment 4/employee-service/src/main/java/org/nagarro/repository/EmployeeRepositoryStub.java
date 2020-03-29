package org.nagarro.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.nagarro.model.Employee;

public class EmployeeRepositoryStub implements EmployeeRepository {
	/* (non-Javadoc)
	 * @see org.nagarro.repository.EmployeeRepository#findAllActivities()
	 */
	private List<Employee> employees;
	
	
	public EmployeeRepositoryStub() {
	
		if(employees == null) {
			employees = new ArrayList<Employee>();
			Employee e = new Employee();
			e.setEmployeeCode((long) 999);
			e.setEmployeeName("John Doe");
			e.setLocation("Noida");
			e.setEmail("john@doe.com");
			e.setDateOfBirth(LocalDate.of(1990, 01, 01));

			Employee e1 = new Employee();
			e1.setEmployeeCode((long) 888);
			e1.setEmployeeName("Mary Jane");
			e1.setLocation("Gurgaon");
			e1.setEmail("mary@jane.com");
			e1.setDateOfBirth(LocalDate.of(1990, 12, 31));
			employees.add(e1);
			employees.add(e);
		}
		
		

		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public List<Employee> findAllEmployees(){
		return employees;
	}
	
	@Override
	public Employee getEmployee(Long employeeCode) {
		Employee employee = null;
		System.out.println(employees.size() + " AND EMPLOYEE CODE : " + employeeCode);
		for(Employee emp : employees) {
			System.out.println("empEmployecode reposite service : " + emp.getEmployeeCode());
			if(emp.getEmployeeCode().equals(employeeCode)) {
			
				employee = emp;
				break;
			}
		}
		if(employee == null) {
			return null;
		}
		return employee;
	}


	

	@Override
	public Employee updateEmployee(Long code, Employee employeeToUpdate) {
		// TODO Auto-generated method stub
		int index = -1;
		for(Employee emp : employees) {
			if(emp.getEmployeeCode().equals(code) ){
				index = employees.indexOf(emp);
			}
		}
		if(index != -1) {
			employees.remove(index);
			employees.add(index, employeeToUpdate);
		}
		
		return employeeToUpdate;
	}
	


}
