package org.nagarro.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.nagarro.model.Flight;
import org.nagarro.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("searchFlightService")
public class SearchFlightServiceImpl implements SearchFlightService {

	@Autowired
	FlightRepository flightRepository;
	
	public List<Flight> searchFlight(Flight searchData) {
		List<Flight> availableFlights = new ArrayList<Flight>();
		List<Flight> flightLists =  flightRepository.findAll();
		System.out.println("Flights count : " + flightLists.size());
		if(!flightLists.isEmpty()) {
			
			for (Iterator<Flight> iterator = flightLists.iterator(); iterator.hasNext();) {
				Flight flight = (Flight) iterator.next();
				System.out.println("Flight date : "+ flight.getValidTill());
				System.out.println("Search date : "+ searchData.getValidTill());
				System.out.println(" (searchData.getValidTill().before(flight.getValidTill()) : " +  searchData.getValidTill().before(flight.getValidTill()));
				if(searchData.getArrivalLocation().equalsIgnoreCase(flight.getArrivalLocation()) 
						&& searchData.getDepartureLocation().equalsIgnoreCase(flight.getDepartureLocation())
						&& flight.getFlightClass().contains(searchData.getFlightClass())) {
					availableFlights.add(flight);
					System.out.println("Flight found : " + flight.getFlightNumber());
				}
			}
		}
		return availableFlights;
	}
	
//	&& (searchData.getValidTill().before(flight.getValidTill())
	

}
