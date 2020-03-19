package com.reservation.airline;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
	private String flightNumber;
	private String departureLocationCode;
	private String arrivalLocationCode;
	private Date validatyTill;
	private String flightTime;
	private double flightDuration;
	private double fare;
	private String seatAvailability;
	private String flightClass;
	

	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * @return the departureLocationCode
	 */
	public String getDepartureLocationCode() {
		return departureLocationCode;
	}

	/**
	 * @param departureLocationCode the departureLocationCode to set
	 */
	public void setDepartureLocationCode(String departureLocationCode) {
		this.departureLocationCode = departureLocationCode;
	}

	/**
	 * @return the arrivalLocationCode
	 */
	public String getArrivalLocationCode() {
		return arrivalLocationCode;
	}

	/**
	 * @param arrivalLocationCode the arrivalLocationCode to set
	 */
	public void setArrivalLocationCode(String arrivalLocationCode) {
		this.arrivalLocationCode = arrivalLocationCode;
	}

	/**
	 * @return the validatyTill
	 */
	public Date getValidatyTill() {
		return validatyTill;
	}

	/**
	 * @param validatyTill the validatyTill to set
	 */
	public void setValidatyTill(String validatyTill) {
		try {
			SimpleDateFormat formater = new SimpleDateFormat("dd-mm-yyyy");
			this.validatyTill = formater.parse(validatyTill);	
		}catch(Exception e){
			System.out.println("check date "+ validatyTill);
		}
		
	}

	/**
	 * @return the flightTime
	 */
	public String getFlightTime() {
		return flightTime;
	}

	/**
	 * @param flightTime the flightTime to set
	 */
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	/**
	 * @return the flightDuration
	 */
	public double getFlightDuration() {
		return flightDuration;
	}

	/**
	 * @param flightDuration the flightDuration to set
	 */
	public void setFlightDuration(String flightDuration) {
		this.flightDuration = Double.parseDouble(flightDuration);
	}

	/**
	 * @return the fare
	 */
	public Double getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(String fare) {
		this.fare = Double.parseDouble(fare);;
	}

	/**
	 * @return the seatAvailability
	 */
	public String getSeatAvailability() {
		return seatAvailability;
	}

	/**
	 * @param seatAvailability the seatAvailability to set
	 */
	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	/**
	 * @return the flightClass
	 */
	public String getFlightClass() {
		return flightClass;
	}

	/**
	 * @param flightClass the flightClass to set
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	
}
