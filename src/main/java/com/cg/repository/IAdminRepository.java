package com.cg.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Admin;



public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	@Transactional
	@Modifying
	@Query("delete from Admin a")
	public void deleteAdmin();

}
