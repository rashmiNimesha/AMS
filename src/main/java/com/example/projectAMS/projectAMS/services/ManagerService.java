package com.example.projectAMS.projectAMS.services;

import java.util.List;

import com.example.projectAMS.projectAMS.entities.Manager;

public interface ManagerService {

	public void updateManager(Long managerId, Manager manager);
	public void createManager(Manager manager);
	public List<Manager>getManagers();
	public Manager getManagerById(Long managerId);
	public String login(Manager manager);
}
