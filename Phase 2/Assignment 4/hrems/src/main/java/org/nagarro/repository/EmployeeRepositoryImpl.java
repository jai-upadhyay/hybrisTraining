package org.nagarro.repository;

import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.nagarro.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate; 

@Repository 
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	private RestTemplate restTemplate = new RestTemplate();
	private String BASE_URI = "http://localhost:8080/employee-service/webapi/employees";
	
	public List<Employee> getAllEmployees() {
//		List<Employee> employees = new ArrayList<Employee>();
//		Employee e = new Employee();
//		e.setEmployeeCode((long) 101);
//		e.setEmployeeName("John Doe");
//		e.setLocation("Noida");
//		e.setEmail("john@doe.com");
//		e.setDateOfBirth(LocalDate.of(1990, 01, 01));
//
//		Employee e1 = new Employee();
//		e1.setEmployeeCode((long) 102);
//		e1.setEmployeeName("Mary ;Jane");
//		e1.setLocation("Gurgaon");
//		e1.setEmail("mary@jane.com");
//		e1.setDateOfBirth(LocalDate.of(1990, 12, 31));
//		employees.add(e1);
//		employees.add(e);
//		return employees;
		String endpoint = "/";
		@SuppressWarnings("unchecked")
		List<Employee> result = (List<Employee>) restTemplate.getForObject(BASE_URI + endpoint, List.class);
		System.out.println("In repos: " +result.size());
		return result;
	}

	public Employee getEmployee(long employeeCode) {
//		Employee e1 = new Employee();
//		e1.setEmployeeCode((long) 102);
//		e1.setEmployeeName("Mary ;Jane");
//		e1.setLocation("Gurgaon");
//		e1.setEmail("mary@jane.com");
//		e1.setDateOfBirth(LocalDate.of(1990, 12, 31));
//		return e1;
		String endpoint =BASE_URI + "/get/" + employeeCode;
		System.out.println(endpoint);
		String result = restTemplate.getForObject(endpoint, String.class );
		JSONObject jsonResult = null;
		try {
			Object jsonObj = new JSONParser().parse(result);

			 jsonResult = (JSONObject) jsonObj;
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(jsonResult == null) {
			return null;
		}
		Employee e = new Employee();
		e.setEmployeeCode((Long)jsonResult.get("employeeCode"));
		e.setDateOfBirth((LocalDate)LocalDate.parse(jsonResult.get("dateOfBirth").toString()));
		e.setLocation(jsonResult.get("location").toString());
		e.setEmail(jsonResult.get("email").toString());
		e.setEmployeeName(jsonResult.get("employeeName").toString());
		System.out.println("Employee : " + e);
		return e;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> updateEmployee(Employee employee) {
		String endpoint =BASE_URI + "/update/" + employee.getEmployeeCode();
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(endpoint);
		
		Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(employee, MediaType.APPLICATION_JSON));
		 
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
//		Employee response = target.path("employees/"+id).request(MediaType.APPLICATION_JSON).get(Employee.class);
		System.out.println(response);
		return getAllEmployees();
	}
	
	
	

}
