package com.cg.model;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class AdminPayload {
	@Column(name = "admin_name")
	private String adminName;
	@NotEmpty(message = "Password cannot be empty")
	private String password;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
