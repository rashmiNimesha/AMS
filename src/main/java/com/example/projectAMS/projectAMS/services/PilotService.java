package com.example.projectAMS.projectAMS.services;

import java.util.List;

import com.example.projectAMS.projectAMS.entities.Pilot;

public interface PilotService {

	public void delete(Long pilotId);
	public Pilot updatePilot(Long pilotId, Pilot pilot);
	public Pilot createPilot(Pilot pilot);
	public List<Pilot> getPilots();
	public Pilot getPilotById(Long pilotId);
}
