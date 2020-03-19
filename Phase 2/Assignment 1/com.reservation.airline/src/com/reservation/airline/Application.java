package com.reservation.airline;


import java.util.ArrayList;


public class Application {
	 
	public static void main(String[] args) {
		
			ArrayList<Flight> flights = Utility.LoadFlightDetails();
			
			System.out.println("FLights are loaded, Please input the Following Details");
//			Booking book = new Booking("DEL","BGR","16-12-2013","B","");
			Booking book = Utility.InputDetails();
			if(book == null) {
				System.out.println("Please try again later!");
				return;
			}
			ArrayList<Flight> availableFlight = book.searchFlights(flights);
			Utility.SortByPreference(availableFlight, book.preference);
			Utility.PrintFlightDetails(availableFlight, book);
		}
	}

