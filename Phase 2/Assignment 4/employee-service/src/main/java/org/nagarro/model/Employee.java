package org.nagarro.model;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.xml.bind.annotation.XmlRootElement;

import jdk.jfr.Timestamp;

@XmlRootElement
public class Employee {
	
	private Long employeeCode;
	private String employeeName;
	private String location;
	private String email;
	@JsonbDateFormat
	private LocalDate dateOfBirth;
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public Long getEmployeeCode() {
		return employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public String getLocation() {
		return location;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [employeeCode=" + employeeCode + ", employeeName=" + employeeName + ", location=" + location
				+ ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}
}