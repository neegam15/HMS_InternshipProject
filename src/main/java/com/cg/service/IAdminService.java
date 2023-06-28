package com.cg.service;

import com.cg.entity.Admin;
import com.cg.model.AdminPayload;

public interface IAdminService {
	Admin saveAdmin();

	String login(AdminPayload adminPayload);

	Admin showAdminById(int adminId);

	void logout();

}