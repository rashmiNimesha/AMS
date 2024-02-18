package com.example.projectAMS.projectAMS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionController {
 
	@org.springframework.web.bind.annotation.ExceptionHandler(PlaneNotFoundException.class)
    ResponseEntity<String> PlaneNotFoundException(){
        return new ResponseEntity<String>("Plane not found", HttpStatus.NOT_FOUND);
    }
	@org.springframework.web.bind.annotation.ExceptionHandler(PilotNotFoundException.class)
    ResponseEntity<String> PilotNotFoundException(){
        return new ResponseEntity<String>("Pilot not found", HttpStatus.NOT_FOUND);
    }
	@org.springframework.web.bind.annotation.ExceptionHandler(HangarNotFoundException.class)
    ResponseEntity<String> HangarNotFoundException(){
        return new ResponseEntity<String>("Hangar not found", HttpStatus.NOT_FOUND);
    }
	@org.springframework.web.bind.annotation.ExceptionHandler(AdminNotFoundException.class)
    ResponseEntity<String> AdminNotFoundException(){
        return new ResponseEntity<String>("Admin not found", HttpStatus.NOT_FOUND);
    }
	@org.springframework.web.bind.annotation.ExceptionHandler(ManagerNotFoundException.class)
    ResponseEntity<String> ManagerNotFoundException(){
        return new ResponseEntity<String>("Manager not found", HttpStatus.NOT_FOUND);
    }
}