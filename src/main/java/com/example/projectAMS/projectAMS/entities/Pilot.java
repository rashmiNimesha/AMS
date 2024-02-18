package com.example.projectAMS.projectAMS.entities;

import com.example.projectAMS.projectAMS.controllers.PlaneController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pilot {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pilotId;
	
	@NotNull(message = "Pilot name cannot be null")
	private String pilotName;
	@NotNull(message = "Flying Hours cannot be null")
	private long flyingHours;
	
	@ManyToOne
	@NotNull(message = "Pilot's allocated plane must be added!")
	private Plane plane;

 
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	public long getPilotId() {
		return pilotId;
	}
	public void setPilotId(long pilotId) {
		this.pilotId = pilotId;
	}
	public String getPilotName() {
		return pilotName;
	}
	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}
	public long getFlyingHours() {
		return flyingHours;
	}
	public void setFlyingHours(long flyingHours) {
		this.flyingHours = flyingHours;
	}
 
	@Override
	public String toString() {
		return "Pilot [pilotId=" + pilotId + ", pilotName=" + pilotName + ", flyingHours=" + flyingHours + ", plane="
				+ plane + "]";
	}

}