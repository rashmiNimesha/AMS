package com.example.projectAMS.projectAMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.projectAMS.projectAMS.entities.Plane;
import com.example.projectAMS.projectAMS.exceptions.PlaneNotFoundException;
import com.example.projectAMS.projectAMS.repositories.PlaneRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlaneServiceImplication implements PlaneService{
 
	@Autowired
	PlaneRepository planerepo;
	public void delete(@PathVariable("planeId") Long planeId) {
		if(planerepo.findById(planeId).isEmpty()) {
			throw new PlaneNotFoundException("Plane not found!");
		}else {
			planerepo.deleteById(planeId);
		}
	}
	public Plane updatePlane(Long planeId, Plane plane) {
		if(planerepo.findById(planeId).isEmpty()) {
			throw new PlaneNotFoundException("Plane not found!");
		}else {
			plane.setPlaneId(planeId);
			return planerepo.save(plane);
		}
	}
	public Plane createPlane(Plane plane) {
		return planerepo.save(plane);
	}
	public List<Plane> getPlanes(){
		return planerepo.findAll();
	}
	public Plane getPlaneById(Long planeId) {
		if(planerepo.findById(planeId).isEmpty()) {
			throw new PlaneNotFoundException("Plane not found!");
		}else {
			return planerepo.findById(planeId).get();
		}
	}
}