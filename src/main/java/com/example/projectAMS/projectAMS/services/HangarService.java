package com.example.projectAMS.projectAMS.services;

import com.example.projectAMS.projectAMS.entities.Hangar;

import jakarta.validation.constraints.AssertFalse.List;

public interface HangarService {
	public void delete(Long hangarId);
	public Hangar updateHangar(Long hangarId, Hangar hangar);
	public Hangar createHangar(Hangar hangar);
	public java.util.List<Hangar>getHangars();
	public Hangar getHangarById(Long hangarId);

}
