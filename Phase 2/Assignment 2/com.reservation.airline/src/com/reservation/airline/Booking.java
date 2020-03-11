package com.reservation.airline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Booking {
	String departureLocation;
	String arrivalLocation;
	String journeyDate;
	String journeyClass;
	String preference;
	
	public Booking(String departureLocation, String arrivalLocation, String journeyDate, String journeyClass, String preference) {
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.journeyDate = journeyDate;
		this.journeyClass = journeyClass;
		this.preference = preference;
	}
	
	private boolean searchFlightUsingArrival(Flight flight) {
		if(this.arrivalLocation.equalsIgnoreCase(flight.getArrivalLocationCode())) {
			return true;
		}
		return false;
	}
	private boolean searchFlightUsingDeparture(Flight flight) {
		if(this.departureLocation.equalsIgnoreCase(flight.getDepartureLocationCode())) {
			return true;
		}
		return false;
	}
	private boolean searchFlightUsingClass(Flight flight) {
		if(flight.getFlightClass().contains(this.journeyClass)) {
			return true;
		}
		return false;
	}
	private boolean searchFlightUsingDate(Flight flight) {
		try {
		Date date= new SimpleDateFormat("dd-mm-yyyy").parse(this.journeyDate);
			if(date.before(flight.getValidatyTill())) {
				return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Flight> searchFlights(ArrayList<Flight> flights) {
		ArrayList<Flight> availableFlights = new ArrayList<Flight>();
		for(Flight flight : flights) {
			if(IsFlightFound(flight)) {
				availableFlights.add(flight);				
			}
			
		}
		return  availableFlights;
	}
	
	private boolean IsFlightFound(Flight flight) {
		if(searchFlightUsingDate(flight)) {
			if(searchFlightUsingArrival(flight) && searchFlightUsingDeparture(flight)) {
				if(searchFlightUsingClass(flight)) {
					return true;
				}
			}
		}
		return false;
	}

	
}
