package com.example.projectAMS.projectAMS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Plane {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long planeId;
	
	@NotNull(message = "Plane name cannot be null")
	private String planeName;
	@NotNull(message = "Plane type cannot be null")
	private String planeType;
	@NotNull(message = "Number of seats cannot be null")
	private int numberOfSeats;
	
	
	@OneToOne
	private Hangar hangar;
 
	public Hangar getHangar() {
		return hangar;
	}
 
	public void setHangar(Hangar hangar) {
		this.hangar = hangar;
	}
 
	public Plane() {
	}
	public long getPlaneId() {
		return planeId;
	}
	public void setPlaneId(long planeId) {
		this.planeId = planeId;
	}
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public String getPlaneType() {
		return planeType;
	}
	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	@Override
	public String toString() {
		return "Plane [planeId=" + planeId + ", planeName=" + planeName + ", planeType=" + planeType
				+ ", numberOfSeats=" + numberOfSeats + ", hangar=" + hangar + "]";
	}
 
	
}