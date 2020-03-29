package org.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.nagarro.model.Employee;
import org.nagarro.model.User;
import org.nagarro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("employee")
public class EmployeesController {

	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "employees", method = RequestMethod.GET)
	public String getEmployees(Model model, HttpSession session) {
		List<Employee> employees = service.getAllEmployees();
		model.addAttribute("employeesList", employees);		
		return "employees";
	}
	
	@RequestMapping(value = "/{employeeCode}", method = RequestMethod.POST)
	public String editEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result ,  HttpSession session) {
		
		
		System.out.println("Employee in post " + employee);
		List<Employee> employees = service.updateEmployee(employee);
		session.setAttribute("employeesList", employees);
		return "redirect:employees";
		
	}
	
	@RequestMapping(value = "/{employeeCode}", method = RequestMethod.GET)
	public String getUpdateEmployee(@PathVariable("employeeCode") long employeeCode, Model model,  HttpSession session) {
		Employee employee = (Employee) session.getAttribute("employee");
		if(employee == null) {
			employee = service.getEmployee(employeeCode);
			System.out.println(" null Employee "+ employeeCode );
		}
		System.out.println(employeeCode);
		System.out.println("Employee in get " + employee);
		model.addAttribute("employee",employee);
		
		session.setAttribute("employee",employee);
		return "updateEmployee";
		
	}
	
//	@RequestMapping(value = "searchFlight", method = RequestMethod.POST)
//	public String searchFlight(Model model, HttpSession session) {
//		Flight searchData = (Flight) session.getAttribute("flight");
//		List< Flight> availableFlights = service.searchFlight(searchData);
//		session.setAttribute("availableFlights", availableFlights);
//		return "redirect:availableFlightsResult";
//	}
	
//	@SuppressWarnings("checked")
//	@RequestMapping(value = "availableFlightsResult", method = RequestMethod.GET)
//	public String listAvailableFlight(Model model, HttpSession session) {
//		List<Flight> list = (ArrayList<Flight>) session.getAttribute("availableFlights");
//		model.addAttribute("availableFlights", list);
//		return "availableFlightsResult";
//		
//	}

}
