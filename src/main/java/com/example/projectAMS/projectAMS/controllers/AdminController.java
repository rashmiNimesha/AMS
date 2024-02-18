package com.example.projectAMS.projectAMS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectAMS.projectAMS.entities.Admin;
import com.example.projectAMS.projectAMS.services.AdminService;

import jakarta.validation.Valid;
import org.jboss.logging.Logger;


@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	static Logger log = Logger.getLogger(AdminController.class.getName());
	
	@RequestMapping(value = "/admin/{id}",method = RequestMethod.PUT)
	public ResponseEntity<String> updateAdmin(@PathVariable("id") Long adminId,@RequestBody @Valid Admin admin) {
		adminService.updateAdmin(adminId, admin);
		log.info("Admin is being updated");
		return new ResponseEntity<String>("Admin updated successfully!",HttpStatus.OK);
	}
 
	@RequestMapping(value = "/admin",method = RequestMethod.POST)
	public ResponseEntity<String> createAdmin(@RequestBody @Valid Admin admin) {
		adminService.createAdmin(admin);
		log.info("Admin is being created");
		return new ResponseEntity<String>("Admin added successfully!",HttpStatus.CREATED);
	}
 
	@RequestMapping(value = "/admin/{id}",method = RequestMethod.GET)
	public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long adminId) {
		log.info("Getting admin by id-->done");
		return new ResponseEntity<Admin>(adminService.getAdminById(adminId),HttpStatus.OK);
	}
	@PostMapping("/admin/login")
    public ResponseEntity<String> login(@RequestBody Admin admin) {
        log.info("Admin is being logged in...");
        return new ResponseEntity<String>(adminService.login(admin), HttpStatus.OK);
    }

}
