package com.cg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.entity.User;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.AdminPayload;
import com.cg.repository.IAdminRepository;
import com.cg.repository.IUserRepository;

@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminRepository adminRepository;

	@Autowired
	private IUserRepository userRepository;

	@Override
	public Admin saveAdmin() {
		Admin admin = new Admin();
		User user = userRepository.getAdmin();
		String userName = user.getUserName();
		String password = user.getPassword();
		admin.setAdminName(userName);
		admin.setPassword(password);
		adminRepository.save(admin);
		return admin;

	}

	@Override
	public String login(AdminPayload adminPayload) {
		String userName = adminPayload.getAdminName();
		String password = adminPayload.getPassword();
		Admin adminSave = saveAdmin();
		if ((adminSave.getPassword().equals(password)) && (adminSave.getAdminName().equals(userName))) {
			return "Admin logged in successfully";
		} else {
			return "Admin log in unsuccessful";
		}

	}

	@Override
	public Admin showAdminById(int adminId) {
		Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
		if (optionalAdmin.isEmpty())
			throw new ResourceNotFoundException("Admin Not found with id : " + adminId);
		return optionalAdmin.get();
	}

	@Override
	public void logout() {
		adminRepository.deleteAdmin();

	}

}
