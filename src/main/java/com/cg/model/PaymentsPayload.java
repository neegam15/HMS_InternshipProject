package com.cg.model;

import javax.persistence.Column;

public class PaymentsPayload {
	@Column(name = "booking_id")
	private int bookingId;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

}
