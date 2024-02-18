package com.example.projectAMS.projectAMS.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Hangar {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hangarId;
	
	@OneToOne
	private Plane plane;
 
	public long getHangarId() {
		return hangarId;
	}
	public void setHangarId(long hangarId) {
		this.hangarId = hangarId;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	@Override
	public String toString() {
		return "Hangar [hangarId=" + hangarId + ", plane=" + plane + "]";
	}

}