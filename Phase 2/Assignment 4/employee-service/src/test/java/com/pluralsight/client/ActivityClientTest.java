package com.pluralsight.client;

import static org.junit.Assert.*;

import org.junit.Test;
import org.nagarro.client.ActivityClient;
import org.nagarro.model.Employee;

public class ActivityClientTest {

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		
		Employee activity = client.get("1234");
		
		System.out.println(activity);
		
		assertNotNull(activity);
	}

}
