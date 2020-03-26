package org.nagarro.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="flights")
public class Flight {
	@Id
	@GeneratedValue
	private Long flightId;
	private String flightNumber;
	private String departureLocation;
	private String arrivalLocation;
	@Temporal(TemporalType.DATE)
	private Calendar validTill;
	private String flightTime;
	private Double flightDuration;
	private Double fare;
	private String seatAvailability;
	private String flightClass;
	
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public String getDepartureLocation() {
		return departureLocation;
	}
	public Double getFare() {
		return fare;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public Double getFlightDuration() {
		return flightDuration;
	}
	public Long getFlightId() {
		return flightId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public String getSeatAvailability() {
		return seatAvailability;
	}
	public Calendar getValidTill() {
		return validTill;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public void setFlightDuration(Double flightDuration) {
		this.flightDuration = flightDuration;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}
	public void setValidTill(Calendar validTill) {
		this.validTill = validTill;
	}

}
