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

import com.example.projectAMS.projectAMS.entities.Manager;
import com.example.projectAMS.projectAMS.services.ManagerService;

import jakarta.validation.Valid;

@RestController
public class ManagerController {

	@Autowired
	ManagerService managerService;
	static Logger log = Logger.getLogger(ManagerController.class.getName());
	@RequestMapping(value = "/managers/{id}",method = RequestMethod.PUT)
	public ResponseEntity<String> updateManager(@PathVariable("id") Long managerId,@RequestBody @Valid Manager manager){
		managerService.updateManager(managerId,manager);
		log.info("Manager is being updated");
		return new ResponseEntity<>("Manager updated successfully!",HttpStatus.OK);	
	} 
	@RequestMapping(value = "/managers",method = RequestMethod.POST)
	public ResponseEntity<String> createManager(@RequestBody @Valid Manager manager){
		managerService.createManager(manager);
		log.info("Manager is being created");
		return new ResponseEntity<>("Manager added successfully!",HttpStatus.CREATED);		
	}
	@RequestMapping(value = "/managers")
	public ResponseEntity<List<Manager>>getManagers(){
		log.info("Getting manager list-->done");
		return new ResponseEntity<List<Manager>>(managerService.getManagers(),HttpStatus.OK);
	}
	@RequestMapping(value = "/managers/{id}",method = RequestMethod.GET)
	public ResponseEntity<Manager>getManagersById(@PathVariable("id") Long managerId){
		log.info("Getting manager by id-->done");
		return new ResponseEntity<Manager>(managerService.getManagerById(managerId),HttpStatus.OK);
	}
	@PostMapping("/managers/login")
    public ResponseEntity<String> login(@RequestBody Manager manager) {
        log.info("Manager is being logged in...");
        return new ResponseEntity<String>(managerService.login(manager), HttpStatus.OK);
    }
}
