package org.nagarro.service;

import java.util.List;

import org.nagarro.model.Flight;

public interface SearchFlightService {
	List<Flight> searchFlight(Flight searchData);
}
