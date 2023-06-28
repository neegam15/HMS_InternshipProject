package com.cg.model;

import java.time.LocalDate;

import javax.persistence.Column;

public class BookingDetailsPayload {
	@Column(name = "booking_id")
	private int bookingId;
	@Column(name = "hotel_id")
	private int hotelId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "booked_from")
	private LocalDate bookedFrom;
	@Column(name = "booked_to")
	private LocalDate bookedTo;
	@Column(name = "no_of_adults")
	private int noOfAdults;
	@Column(name = "no_of_children")
	private int noOfChildren;
	private double amount;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(LocalDate bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public LocalDate getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(LocalDate bookedTo) {
		this.bookedTo = bookedTo;
	}

	public int getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
