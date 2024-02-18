package com.example.projectAMS.projectAMS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long managerId;
	
	@NotNull(message = "First name cannot be null")
	private String firstName;
	@NotNull(message = "Last name cannot be null")
	private String lastName;
	@NotNull(message = "Age cannot be null")
	private int age;
	@NotNull(message = "Age cannot be null")
	private String gender;
	@NotNull(message = "Contact number cannot be null")
	private long contactNumber;
	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 15, message = "Invalid password: Must be of 8 - 15 characters")
	private String password;
	@NotNull(message = "Should be true or false")
	private boolean isapproved;
	public boolean isIsapproved() {
		return isapproved;
	}
	public void setIsapproved(boolean isapproved) {
		this.isapproved = isapproved;
	}
	public long getManagerId() {
		return managerId;
	}
	public void setManagerId(long managerId) {
		this.managerId = managerId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", gender=" + gender + ", contactNumber=" + contactNumber + ", password=" + password
				+ ", isapproved=" + isapproved + "]";
	}

}