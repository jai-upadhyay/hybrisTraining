package org.nagarro.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.nagarro.model.Employee;

public class ActivityClient {

	private Client client;
	
	public ActivityClient() {
		client = ClientBuilder.newClient();
	}
	
	public Employee get(String id) {
		WebTarget target = client.target("http://localhost:8080/exercise-service/webapi/");
		System.out.println(id);
		Employee response = target.path("employees/"+id).request(MediaType.APPLICATION_JSON).get(Employee.class);
		System.out.println(response);
		return response;
		
	}
}
