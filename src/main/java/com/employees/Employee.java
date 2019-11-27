package com.employees;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	@JsonProperty("FIRST_NAME")
	@NotNull(message = "First Name cannot be blank")
	private String firstName;

	@JsonProperty("LAST_NAME")
	private String lastName;

	@JsonProperty("GENDER")
	@NotNull(message = "Gender cannot be blank")
	private char gender;

	@JsonProperty("DOB")
	private String dateOfBirth;

	@JsonProperty("DEPARTMENT")
	private String department;

	public Employee(@NotNull(message = "First Name cannot be blank") String firstName, String lastName,
			@NotNull(message = "Gender cannot be blank") char gender, String dateOfBirth, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
