package com.example.projectAMS.projectAMS.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.projectAMS.projectAMS.entities.Hangar;
import com.example.projectAMS.projectAMS.exceptions.HangarNotFoundException;
import com.example.projectAMS.projectAMS.repositories.HangarRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HangarServiceImplication implements HangarService{
	
	@Autowired
	HangarRepository hangarrepo;
	
	public void delete(@PathVariable("hangarId")Long hangarId) {
		if(hangarrepo.findById(hangarId).isEmpty()) {
			throw new HangarNotFoundException("Hangar Not Found!");
		}else {
			hangarrepo.deleteById(hangarId);
		}
	}
	
	

	public Hangar updateHangar(Long hangarId, Hangar hangar) {
		if(hangarrepo.findById(hangarId).isEmpty()) {
			throw new HangarNotFoundException("Hangar Not Found!");
		}else {
			hangar.setHangarId(hangarId);
			return hangarrepo.save(hangar);
		}
	}
	public Hangar createHangar(Hangar hangar) {
		return hangarrepo.save(hangar);
	}
	public List<Hangar> getHangars(){
		return hangarrepo.findAll();
	}
	public Hangar getHangarById(Long hangarId) {
		if(hangarrepo.findById(hangarId).isEmpty()) {
			throw new HangarNotFoundException("Hangar Not Found!");
		}else {
			return hangarrepo.findById(hangarId).get();
		}
 
	}
}
