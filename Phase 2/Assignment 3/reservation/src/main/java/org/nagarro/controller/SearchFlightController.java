package org.nagarro.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.nagarro.model.Flight;
import org.nagarro.service.SearchFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("flight")
public class SearchFlightController {

	@Autowired
	private SearchFlightService searchService;

	@RequestMapping(value = "searchFlight", method = RequestMethod.GET)
	public String getSearchPage(Model model, HttpSession session) {
		Flight flightData = (Flight) session.getAttribute("flight");
		
		if(flightData == null) {			
			flightData = new Flight();
			Calendar date = Calendar.getInstance();
			date.set(2013, 12, 1);
			flightData.setArrivalLocation("DEL");
			flightData.setDepartureLocation("BGR");
			flightData.setFlightClass("E");
			flightData.setValidTill(date);
		}
		model.addAttribute("flight", flightData);
		
		return "searchFlight";
	}
	
	@RequestMapping(value = "searchFlight", method = RequestMethod.POST)
	public String searchFlight(Model model, HttpSession session) {
		Flight searchData = (Flight) session.getAttribute("flight");
		List< Flight> availableFlights = searchService.searchFlight(searchData);
		session.setAttribute("availableFlights", availableFlights);
		return "redirect:availableFlightsResult";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "availableFlightsResult", method = RequestMethod.GET)
	public String listAvailableFlight(Model model, HttpSession session) {
		List<Flight> list = (ArrayList<Flight>) session.getAttribute("availableFlights");
		model.addAttribute("availableFlights", list);
		return "availableFlightsResult";
		
	}

}
