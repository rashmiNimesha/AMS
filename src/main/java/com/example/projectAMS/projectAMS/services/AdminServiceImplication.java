package com.example.projectAMS.projectAMS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectAMS.projectAMS.entities.Admin;
import com.example.projectAMS.projectAMS.exceptions.AdminNotFoundException;
import com.example.projectAMS.projectAMS.repositories.AdminRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImplication implements AdminService {
	

	@Autowired
	AdminRepository adminRepository;
 
	@Override
	public void updateAdmin(Long adminId, Admin admin) {
		if(adminRepository.findById(adminId).isEmpty()) {
			throw new AdminNotFoundException("Admin Not Found!");
		}else {
			admin.setVendorId(adminId);
			adminRepository.save(admin);
		}	
	}
 
	@Override
	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminRepository.save(admin);
	}
 
	@Override
	public Admin getAdminById(Long adminId) {
		if(adminRepository.findById(adminId).isEmpty()) {
			throw new AdminNotFoundException("Admin Not Found!");
		}else {
			return adminRepository.findById(adminId).get();
		}
	}
	@Override
    public String login(Admin admin) {
        if (adminRepository.findById(admin.getVendorId()).isEmpty()) {
        	throw new AdminNotFoundException("Admin Not Found!");
        } else {
            if (adminRepository.findById(admin.getVendorId()).get().getPassword().equals(admin.getPassword())) {
                return "Admin logged in successfully";
            } else {
                return "Incorrect password";
            }
        }
    }
 
	
}
