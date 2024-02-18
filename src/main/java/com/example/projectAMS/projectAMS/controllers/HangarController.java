package com.example.projectAMS.projectAMS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectAMS.projectAMS.entities.Hangar;
import com.example.projectAMS.projectAMS.services.HangarService;

import org.jboss.logging.Logger;


@RestController
public class HangarController {
	
	@Autowired
	HangarService hangarService;
	static Logger log = Logger.getLogger(HangarController.class.getName());
	@RequestMapping(value = "/hangars/{hangarId}",method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("hangarId")Long hangarId){
		hangarService.delete(hangarId);
		log.info("Hangar is being deleted");
		return new ResponseEntity<>("Hangar deleted successfully!",HttpStatus.OK);
	}
	@RequestMapping(value = "/hangars/{hangarId}",method = RequestMethod.PUT)
	public ResponseEntity<String> updateHangar(@PathVariable("hangarId") Long hangarId,@RequestBody Hangar hangar){
		hangarService.updateHangar(hangarId,hangar);
		return new ResponseEntity<>("Hangar updated successfully!",HttpStatus.OK);	
	} 
	@RequestMapping(value = "/hangars",method = RequestMethod.POST)
	public ResponseEntity<String> createHangar(@RequestBody Hangar hangar){
		hangarService.createHangar(hangar);
		log.info("Hangar is being created");
		return new ResponseEntity<>("Hangar added successfully!",HttpStatus.CREATED);		
	}
	@RequestMapping(value = "/hangars")
	public ResponseEntity<List<Hangar>>getHangars(){
		log.info("Getting hangar list-->done");
		return new ResponseEntity<List<Hangar>>(hangarService.getHangars(),HttpStatus.OK);
	}
	@RequestMapping(value = "/hangars/{hangarId}",method = RequestMethod.GET)
	public ResponseEntity<Hangar>getHangarById(@PathVariable("hangarId") Long hangarId){
		log.info("Getting hangar by id-->done");
		return new ResponseEntity<Hangar>(hangarService.getHangarById(hangarId),HttpStatus.OK);
	}

}
