package com.example.projectAMS.projectAMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectAMS.projectAMS.entities.Manager;
import com.example.projectAMS.projectAMS.exceptions.AdminNotFoundException;
import com.example.projectAMS.projectAMS.exceptions.ManagerNotFoundException;
import com.example.projectAMS.projectAMS.repositories.ManagerRespository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ManagerServiceImplication implements ManagerService{
 
	@Autowired
	ManagerRespository managerRespository;
	public void updateManager(Long managerId, Manager manager) {
		if(managerRespository.findById(managerId).isEmpty()) {
			throw new ManagerNotFoundException("Manager Not Found!");
		}else {
			manager.setManagerId(managerId);
			managerRespository.save(manager);
		}	
	}
	public void createManager(Manager manager) {
		managerRespository.save(manager);
	}
	public List<Manager> getManagers(){
		return managerRespository.findAll();
	}
	public Manager getManagerById(Long managerId) {
		if(managerRespository.findById(managerId).isEmpty()) {
			throw new ManagerNotFoundException("Manager Not Found!");
		}else {
			return managerRespository.findById(managerId).get();
		}
	}
	@Override
    public String login(Manager manager) {
        if (managerRespository.findById(manager.getManagerId()).isEmpty()) {
        	throw new AdminNotFoundException("Manager Not Found!");
        } else {
            if (managerRespository.findById(manager.getManagerId()).get().getPassword().equals(manager.getPassword())&& managerRespository.findById(manager.getManagerId()).get().isIsapproved()) {
                return "Manager logged in successfully";
            } else {
                return "Incorrect password or Not approved by admin";
            }
        }
    }
}