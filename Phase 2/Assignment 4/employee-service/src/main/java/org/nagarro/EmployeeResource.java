package org.nagarro;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nagarro.model.Employee;
import org.nagarro.repository.EmployeeRepository;
import org.nagarro.repository.EmployeeRepositoryStub;

@Path("employees")
public class EmployeeResource {

		private EmployeeRepository employeeRepository = new EmployeeRepositoryStub();
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Employee> getAllEmployees(){
			return employeeRepository.findAllEmployees();
		}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("get/{code}")
		public Employee getEmployee(@PathParam ("code") Long code){
			System.out.println("Emp code "+ code);
			Employee emp =  employeeRepository.getEmployee(code);
			System.out.println(emp);
			return emp;
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		@Path("update/{code}")
		public Employee updateEmployee(@PathParam ("code") Long code, Employee employeeToUpdate){
			System.out.println("Emp code "+ code);
			Employee emp =  employeeRepository.updateEmployee(code,employeeToUpdate);
//			System.out.println(emp);
			return emp;
		}
		
		/*@POST
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		@Path("{activity}")
		public Employee createActivityParams(MultivaluedMap<String, String> formParams) {
			System.out.println(formParams.getFirst("description"));
			System.out.println(formParams.getFirst("duration"));
			return null;
		}*/
		
		/*@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
		@Path("{createActivity}")
		public Employee createActivity(Employee a) {
			System.out.println(a.getDescription());
			System.out.println(a.getDuration());
			return a;
		}*/
		
		
}