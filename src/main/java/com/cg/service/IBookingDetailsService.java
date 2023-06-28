package com.cg.service;

import java.util.List;

import com.cg.entity.BookingDetails;

public interface IBookingDetailsService {
	BookingDetails addBookingDetails(BookingDetails bookingDetails);

	BookingDetails updateBookingDetails(BookingDetails bookingDetails);

	void removeBookingDetails(int bookingId);

	List<BookingDetails> showAllBookingDetails();

	BookingDetails showBookingDetails(int bookingId);

	String refreshBookingDetails();

}