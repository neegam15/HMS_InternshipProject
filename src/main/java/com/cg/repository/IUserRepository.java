package com.cg.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	@Transactional
	@Query("select u from User u where role='admin'")
	public User getAdmin();

}
