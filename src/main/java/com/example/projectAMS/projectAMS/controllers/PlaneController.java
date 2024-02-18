package com.example.projectAMS.projectAMS.controllers;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectAMS.projectAMS.entities.Plane;
import com.example.projectAMS.projectAMS.services.PlaneService;
import jakarta.validation.Valid;

@RestController
public class PlaneController {
	
	@Autowired
	PlaneService planeService;
	static Logger log = Logger.getLogger(PlaneController.class.getName());
 
	@RequestMapping(value = "/planes/{planeId}",method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("planeId") Long planeId){
		planeService.delete(planeId);
		log.info("Plane is being deleted");
		return new ResponseEntity<>("Plane deleted successfully!",HttpStatus.OK);
	}
	@RequestMapping(value = "/planes/{planeId}",method = RequestMethod.PUT)
	public ResponseEntity<String> updatePlane(@PathVariable("planeId") Long planeId,@RequestBody @Valid Plane plane){
		planeService.updatePlane(planeId, plane);
		log.info("Plane is being updated");
		return new ResponseEntity<>("Plane updated successfully!",HttpStatus.OK);
	}
	@RequestMapping(value = "/planes",method = RequestMethod.POST)
	public ResponseEntity<String> createPlane(@RequestBody @Valid Plane plane){
		planeService.createPlane(plane);
		log.info("Plane is being created");
		return new ResponseEntity<>("Plane added successfully!",HttpStatus.CREATED);
	}
	@RequestMapping(value = "/planes")
	public ResponseEntity<List<Plane>> getPlanes(){
		log.info("Getting plane list-->done");
		return new ResponseEntity<List<Plane>>(planeService.getPlanes(),HttpStatus.OK);
	}
	@RequestMapping(value = "/planes/{planeId}",method = RequestMethod.GET)
	public ResponseEntity<Plane> getPlaneById(@PathVariable("planeId") Long planeId){
		log.info("Getting plane by id-->done");
		return new ResponseEntity<Plane>(planeService.getPlaneById(planeId),HttpStatus.OK);
	}

}
