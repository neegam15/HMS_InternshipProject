package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.BookingDetails;




public interface IBookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {


}
