package org.nagarro.service;

import java.util.List;

import org.nagarro.model.Employee;
import org.nagarro.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
//	public List<Flight> searchFlight(Flight searchData) {
//		List<Flight> availableFlights = new ArrayList<Flight>();
//		List<Flight> flightLists =  flightRepository.findAll();
//		System.out.println("Flights count : " + flightLists.size());
//		if(!flightLists.isEmpty()) {
//			
//			for (Iterator<Flight> iterator = flightLists.iterator(); iterator.hasNext();) {
//				Flight flight = (Flight) iterator.next();
//				System.out.println("Flight date : "+ flight.getValidTill());
//				System.out.println("Search date : "+ searchData.getValidTill());
//				System.out.println(" (searchData.getValidTill().before(flight.getValidTill()) : " +  searchData.getValidTill().before(flight.getValidTill()));
//				if(searchData.getArrivalLocation().equalsIgnoreCase(flight.getArrivalLocation()) 
//						&& searchData.getDepartureLocation().equalsIgnoreCase(flight.getDepartureLocation())
//						&& flight.getFlightClass().contains(searchData.getFlightClass())) {
//					availableFlights.add(flight);
//					System.out.println("Flight found : " + flight.getFlightNumber());
//				}
//			}
//		}
//		return availableFlights;
//	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = repository.getAllEmployees();
		return employees;
	}

	public Employee getEmployee(long employeeCode) {
		return repository.getEmployee(employeeCode);

	}

	public List<Employee> updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repository.updateEmployee(employee);
		
	}
	
//	&& (searchData.getValidTill().before(flight.getValidTill())
	

}
