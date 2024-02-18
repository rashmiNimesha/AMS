package com.example.projectAMS.projectAMS.services;

import java.util.List;

import com.example.projectAMS.projectAMS.entities.Plane;

public interface PlaneService {
	public void delete(Long planeId);
	public Plane updatePlane(Long planeId, Plane plane);
	public Plane createPlane(Plane plane);
	public List<Plane> getPlanes();
	public Plane getPlaneById(Long planeId);

}
