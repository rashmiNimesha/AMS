package com.example.projectAMS.projectAMS.services;

import com.example.projectAMS.projectAMS.entities.Admin;

public interface AdminService {

	public void updateAdmin(Long adminId, Admin admin);
	public void createAdmin(Admin admin);
	public Admin getAdminById(Long adminId);
	public String login(Admin admin);
}
