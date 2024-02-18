package com.example.projectAMS.projectAMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.projectAMS.projectAMS.entities.Pilot;
import com.example.projectAMS.projectAMS.exceptions.PilotNotFoundException;
import com.example.projectAMS.projectAMS.repositories.PilotRespository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PilotServiceImplication implements PilotService{
 
	@Autowired
	PilotRespository pilotrepo;
	public void delete(@PathVariable("pilotId") Long pilotId) {
		if(pilotrepo.findById(pilotId).isEmpty()) {
			throw new PilotNotFoundException("Pilot not found!");
		}else {
			pilotrepo.deleteById(pilotId);
		}
 
	}
	public Pilot updatePilot(Long pilotId, Pilot pilot) {
		if(pilotrepo.findById(pilotId).isEmpty()) {
			throw new PilotNotFoundException("Pilot not found!");
		}else {
			pilot.setPilotId(pilotId);
			return pilotrepo.save(pilot);
		}
	}
	public Pilot createPilot(Pilot pilot) {
		return pilotrepo.save(pilot);
	}
	public List<Pilot>getPilots(){
		return pilotrepo.findAll();
	}
	public Pilot getPilotById(Long pilotId) {
		if(pilotrepo.findById(pilotId).isEmpty()) {
			throw new PilotNotFoundException("Pilot not found!");
		}else {
			return pilotrepo.findById(pilotId).get();
		}
 
	}
 
}