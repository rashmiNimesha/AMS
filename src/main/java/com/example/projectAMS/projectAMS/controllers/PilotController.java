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

import com.example.projectAMS.projectAMS.entities.Pilot;
import com.example.projectAMS.projectAMS.services.PilotService;

import jakarta.validation.Valid;


@RestController
public class PilotController {

	@Autowired
	PilotService pilotService;
	static Logger log = Logger.getLogger(PilotController.class.getName());
	@RequestMapping(value = "/pilots/{pilotId}",method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("pilotId")Long pilotId){
		pilotService.delete(pilotId);
		log.info("Pilot is being deleted");
		return new ResponseEntity<>("Pilot deleted successfully!",HttpStatus.OK); 
	}
	@RequestMapping(value = "/pilots/{pilotId}",method = RequestMethod.PUT)
	public ResponseEntity<Object> updatePilot(@PathVariable("pilotId") Long pilotId,@RequestBody @Valid Pilot pilot){
		pilotService.updatePilot(pilotId, pilot);
		log.info("Pilot is being updated");
		return new ResponseEntity<>("Pilot updated successfully!",HttpStatus.OK);
	}
	@RequestMapping(value = "/pilots",method = RequestMethod.POST)
	public ResponseEntity<String> createPilot(@RequestBody @Valid Pilot pilot){
		pilotService.createPilot(pilot);
		log.info("Pilot is being created");
		return new ResponseEntity<>("Pilot added successfully!",HttpStatus.CREATED);
	}
	@RequestMapping(value = "/pilots")
	public ResponseEntity<List<Pilot>> getPilots(){
		log.info("Getting pilot list-->done");
		return new ResponseEntity<List<Pilot>>(pilotService.getPilots(),HttpStatus.OK);
	}
	@RequestMapping(value = "/pilots/{pilotId}",method = RequestMethod.GET)
	public ResponseEntity<Pilot> getPilotById(@PathVariable("pilotId") Long pilotId){
		log.info("Getting pilot by id-->done");
		return new ResponseEntity<Pilot>(pilotService.getPilotById(pilotId),HttpStatus.OK);
	}
}
