/**
 * 
 */
package com.reservation.airline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author jaiupadhyay
 *
 */
public class Utility {	
	
	static ArrayList<Flight> ReadData(File file, ArrayList<Flight> flights){
		if(flights == null) {
			flights = new ArrayList<Flight>();
		}
		if(file.isFile()) {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(file));
		
			String row;
			Flight flight;
			int i = 0;
			while((row = reader.readLine()) != null) {
				flight = new Flight();
				String data[] = row.split("\\|");
				if(i==0) {
					i++;
					continue;
					
				}
				if(data.length != 9) {
					System.out.println("Details of some data is missing in file : "+ file.getName());
				}
				flight.setFlightNumber(data[0]);
				flight.setDepartureLocationCode(data[1]);
				flight.setArrivalLocationCode(data[2]);
				flight.setValidatyTill(data[3]);
				flight.setFlightDuration(data[4]);
				flight.setFlightDuration(data[5]);
				flight.setFare(data[6]);
				flight.setSeatAvailability(data[7]);
				flight.setFlightClass(data[8]);
				flights.add(flight);
				flight = null;
			}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flights;
	}
	
	  private static String getFileExtension(File file) {
	        String fileName = file.getName();
	        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
	        return fileName.substring(fileName.lastIndexOf(".")+1);
	        else return "";
	    }
	static ArrayList<Flight> LoadFlightDetails() {
		String directoryPath = "src\\com\\reservation\\airline\\";
		File files = new File(directoryPath);
		ArrayList<Flight> flights = null;
		for(File f : files.listFiles()) {
			if(f.isFile()) {
				if(getFileExtension(f).equalsIgnoreCase("csv")) {
					flights = ReadData(f, flights);
				}
			}
			
		}	
		return flights;
	}
	
	private static void Print(Object obj) {
		System.out.println(obj);
	}
	
	static Booking InputDetails() {
		Scanner sc = new Scanner(System.in);
		Booking bookingDetails = null;
		Print("Enter the Journey details.\n");
		Print("Departure Location (LOC): ");
		String departureLocation = sc.nextLine();
		if(!departureLocation.matches("[a-zA-Z]{3}")) {
			Print("Departure location entered is invalid");
			sc.close();
			return null;
		}
		Print("Arrival Location (LOC): ");
		String arrivalLocation = sc.nextLine();
		if(!arrivalLocation.matches("[a-zA-Z]{3}")) {
			Print("Arrival location entered is invalid");
			sc.close();
			return null;
		}
		Print("Flight Date (dd-mm-yyyy): ");
		String flightDate = sc.nextLine();
		if(!flightDate.matches("[0-3][0-9]-[01][0-9]-[2][0][1][0-3]")) {
			Print("Flight date entered is invalid");
			sc.close();
			return null;
		}
		Print("Flight Class(B/E) (E = Economic, B = Buisness): ");
		String flightClass = sc.nextLine();
		if(!flightClass.matches("[Bb]|[Ee]")){
			Print("Flight class entered is invalid");
			sc.close();
			return null;
		}
		Print("Output Preference (Fare/Both) (Fare = Sort by Fare, Both = Sort by Fare and Duration)");
		String preference = sc.nextLine();	
		if(!preference.equalsIgnoreCase("fare") && !preference.equalsIgnoreCase("both")) {
			Print("Flight preference entered is invalid");
			sc.close();
			return null;
		}
		bookingDetails = new Booking(departureLocation, arrivalLocation, flightDate, flightClass, preference);
		sc.close();
		return bookingDetails;
	}
	

	static void SortByPreference(ArrayList<Flight> flights ,final String pref) {
		Collections.sort(flights, new Comparator<Flight>() {
			public int compare(Flight f1, Flight f2) {
				double fare1 = f1.getFare();
				double fare2 = f2.getFare();
				int fareComparision = (int)(fare1 - fare2);				
				if(pref.equalsIgnoreCase("fare")) {
					return fareComparision;
				}
				if(fareComparision != 0) {
					return fareComparision;
				}
				double duration1 = f1.getFlightDuration();
				double duration2 = f2.getFlightDuration();
				int durationComparision = (int)(duration1 - duration2);
				return durationComparision;
			}
		});
	}
	
	static void PrintFlightDetails(ArrayList<Flight> flights, Booking book) {
		int i = 0;
		Print("Please find the details as below (sorted by "+ (book.preference.equalsIgnoreCase("fare") ? "FARE" : "FARE and DURATION" )+") :\n");
		Print("Sr.No\t FlightNumber \t Departure \t Arrival \t Flight Date \t Flight Fare(INR) \t Duration (hours)");
		for(Flight flight : flights) {
			Print(++i + " \t " + flight.getFlightNumber() + " \t \t " + flight.getDepartureLocationCode() + " \t \t " + flight.getArrivalLocationCode() + " \t \t " +book.journeyDate +" \t " +  flight.getFare() + " \t \t " + flight.getFlightDuration());
		}
	}
}
