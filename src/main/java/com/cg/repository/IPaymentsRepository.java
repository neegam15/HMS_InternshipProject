package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Payments;



public interface IPaymentsRepository extends JpaRepository<Payments, Integer> {

	Optional<Payments> findByBookingId(int bookingId);
	
}
